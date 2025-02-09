package com.gc.service;

import com.gc.dto.Signup;
import com.gc.dto.SignupDto;

public interface UserAuthService {
	Signup userRegistration(SignupDto signupDTO);
}
