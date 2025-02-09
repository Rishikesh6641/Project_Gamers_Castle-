package com.gc.security;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component

public class JwtUtils {
	
	@Value("${SECRET_KEY}")
	private String jwtSecret;
	
	@Value("${EXP_TIMEOUT}")
	private int jwtExpirationMs;
	
	private Key key;
	
	@PostConstruct
	public void init() {
		byte[] keyBytes = jwtSecret.getBytes();
	    if (keyBytes.length < 64) {
	        throw new IllegalArgumentException("SECRET_KEY must be at least 64 bytes long for HS512");
	    }
		key =Keys.hmacShaKeyFor(jwtSecret.getBytes());
	}
	
	public String generateJwtToken(Authentication authentication) {
		
		CustomUserDetails userPrincipal=(CustomUserDetails) authentication.getPrincipal();

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime()+jwtExpirationMs))
				.claim("authorities",getAuthoritiesInString(userPrincipal.getAuthorities()))
				.signWith(key,SignatureAlgorithm.HS512)
				.compact();
	}
	
	public String getUserNameFromJwtToken(Claims claims) {
		return claims.getSubject();	
	}

	private String getAuthoritiesInString(Collection<? extends GrantedAuthority> authorities) {
		String authorityString = authorities.stream().
				map(authority -> authority.getAuthority())
				.collect(Collectors.joining(","));
		System.out.println(authorityString);
		return authorityString;
	}
	
	public Claims validateJwtToken(String jwtToken) {
		
		try {
			Claims claims=Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(jwtToken)
					.getBody();
			return claims;
			
		}catch(Exception e)
		{
			 System.out.println("Invalid JWT token: " + e.getMessage()); 
			return null;
		}
		
	}
	
	public List<GrantedAuthority> getAuthoritiesFromClaims(Claims claims) {
		String authString = (String) claims.get("authorities");
		List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(authString);
		//authorities.forEach(System.out::println);
		return authorities;
	}
	
	public Authentication populatedAuthenticationTokenFromJWT(String jwt) {
		
		Claims payloadClaims=validateJwtToken(jwt);
		String email=getUserNameFromJwtToken(payloadClaims);
		List<GrantedAuthority> authorities=getAuthoritiesFromClaims(payloadClaims);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email,null,authorities);
		return token;
	}

}