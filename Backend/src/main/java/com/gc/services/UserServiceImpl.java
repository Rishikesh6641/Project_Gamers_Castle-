package com.gc.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gc.custom_exceptions.ApiException;
import com.gc.dto.Signup;
import com.gc.entity.User;
import com.gc.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	//dep : dao layer i/f
		@Autowired
		private UserRepository userDao;
		//dep
		@Autowired
		private ModelMapper mapper;
		//dep 
		@Autowired
		private PasswordEncoder encoder;
	@Override
	public Signup userRegistration(Signup reqDTO) {
		//dto --> entity
		User user=mapper.map(reqDTO, User.class);
		if(userDao.existsByEmail(reqDTO.getEmail()))
			throw new ApiException("Email already exists !!!");
		
		user.setPassword(encoder.encode(user.getPassword()));//pwd : encrypted using SHA
		return mapper.map(userDao.save(user), Signup.class);
	}

}

