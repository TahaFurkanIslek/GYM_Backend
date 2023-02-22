package com.pinsoft.gym.service.auth;

import com.pinsoft.gym.dto.AuthenticationRequest;
import com.pinsoft.gym.dto.AuthenticationResponse;
import com.pinsoft.gym.dto.RegisterRequest;

public interface AuthenticationService {
	AuthenticationResponse adminRegister(RegisterRequest request);
	AuthenticationResponse register(RegisterRequest request);
	AuthenticationResponse authenticate(AuthenticationRequest request);
}
