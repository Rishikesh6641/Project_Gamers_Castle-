package com.gc.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomJwtAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtUtils utils;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String authHeader = request.getHeader("Authorization");
        
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
        	try {
        		 String jwt = authHeader.substring(7);
                 Authentication authentication = utils.populatedAuthenticationTokenFromJWT(jwt);
                 SecurityContextHolder.getContext().setAuthentication(authentication);
                 System.out.println("saved auth token in sec ctx");
        	}catch(Exception e)
        	{
        		System.err.println("Invalid or expired JWT: " + e.getMessage());
        	}
           
        }
        filterChain.doFilter(request, response);
    }
}