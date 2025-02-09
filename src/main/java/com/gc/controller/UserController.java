package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.dto.UserDto;
import com.gc.service.UserService;

@RestController
@RequestMapping("/gc/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/viewProfile/{id}")
	public ResponseEntity<?> viewProfile(@PathVariable Long id){
		return ResponseEntity.ok(service.viewProfile(id));
	}
	
	@PutMapping("/updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody UserDto useDto)
	{
		return ResponseEntity.ok(service.UpdateUser(useDto));
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id)
	{
		return ResponseEntity.ok(service.deleteUser(id));
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity<?> getAllUsers()
	{
		return ResponseEntity.ok(service.viewUser());
	}
}