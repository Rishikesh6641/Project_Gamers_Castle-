package com.gc.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gc.Entities.Address;
import com.gc.Entities.User;
import com.gc.Exception.ApiException;
import com.gc.dto.Signup;
import com.gc.dto.SignupDto;
import com.gc.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserAuthServiceImpl implements UserAuthService{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Signup userRegistration(SignupDto signupDto) {
		
		User user = mapper.map(signupDto,User.class);
		if(repo.existsByEmail(signupDto.getEmail()))
			throw new ApiException("User Already Exist");
		if(user.getAddress()!=null)
		{
			Address address=mapper.map(user.getAddress(),Address.class);
			user.setAddress(address);
		}
		user.setPassword(encoder.encode(user.getPassword()));
		return mapper.map(repo.save(user),Signup.class);
	}

}
