package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.dto.SigninRequest;
import com.gc.dto.SigninResponse;
import com.gc.dto.SignupDto;
import com.gc.security.JwtUtils;
import com.gc.service.MailService;
import com.gc.service.UserAuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/gc/users")
public class UserSignInSignUpController {
	
	@Autowired
	private UserAuthService service;
	
	@Autowired
	private AuthenticationManager authMgr;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private MailService mailService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> UserRegistration(@RequestBody @Valid SignupDto dto){
		
		mailService.sendEmail(dto.getEmail(),"Gamers Castle","Welcome to Gamers Castle");
		return ResponseEntity.status(HttpStatus.CREATED).body(service.userRegistration(dto));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody @Valid SigninRequest request){
		
		UsernamePasswordAuthenticationToken token=
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
		
		Authentication verifiedToken = authMgr.authenticate(token);
		
		SigninResponse response = new SigninResponse(jwtUtils.generateJwtToken(verifiedToken),"authenticated successfull...");
		mailService.sendEmail(request.getEmail(), "Gamers Castle","Email and Password authenticated");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
