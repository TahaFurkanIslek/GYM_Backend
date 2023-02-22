package com.pinsoft.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinsoft.gym.dto.AuthenticationRequest;
import com.pinsoft.gym.dto.AuthenticationResponse;
import com.pinsoft.gym.dto.RegisterRequest;
import com.pinsoft.gym.service.auth.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/GYM/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	@Autowired
	private final AuthenticationService authenticationService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(authenticationService.register(request));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}
	
	@PostMapping("/adminregister")
	public ResponseEntity<AuthenticationResponse> adminRegister(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(authenticationService.adminRegister(request));
	}
 	
}
