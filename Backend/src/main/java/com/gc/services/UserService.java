package com.gc.services;

import com.gc.dto.Signup;

public interface UserService {
	Signup userRegistration(Signup reqDTO);
}
