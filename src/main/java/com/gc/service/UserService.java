package com.gc.service;

import java.util.List;

import com.gc.dto.ApiResponse;
import com.gc.dto.UserDto;

public interface UserService {
	
	 List<UserDto> viewUser();
	 ApiResponse deleteUser(Long id);
	 UserDto viewProfile(Long id);
	 ApiResponse UpdateUser(UserDto userDto);
}
