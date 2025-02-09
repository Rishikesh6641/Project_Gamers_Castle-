package com.gc.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.Entities.User;
import com.gc.Exception.ResourceNotFoundException;
import com.gc.dto.ApiResponse;
import com.gc.dto.UserDto;
import com.gc.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;
	
	@Autowired 
	private ModelMapper mapper;
	
	@Override
	public List<UserDto> viewUser() {
		
		List<UserDto> data=repo.findAll()
				.stream()
				.map(user-> mapper.map(user,UserDto.class))
				.toList();
		return data;
	}

	@Override
	public ApiResponse deleteUser(Long id) {
		if(!repo.existsById(id))
			throw new ResourceNotFoundException("No such User found");
		repo.deleteById(id);
		return new ApiResponse("User Deleted Succefully...");
	}

	@Override
	public UserDto viewProfile(Long id) {
		if(!repo.existsById(id))
			throw new ResourceNotFoundException("No such User found");
		Optional<User> u = repo.findById(id);
		User user = u.get();
		
		UserDto userDto=mapper.map(user,UserDto.class);
		return userDto;
	}

	@Override
	public ApiResponse UpdateUser(UserDto userDto) {	
		Long id =userDto.getId();
		System.out.println(id);
		User user = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("No such user found"));
		user.setPhoneNo(userDto.getPhoneNo());
		user.setEmail(userDto.getEmail());
		repo.save(user);
		
		return new ApiResponse("User Updated successfully...");
	}

}
