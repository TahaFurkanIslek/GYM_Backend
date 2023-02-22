package com.pinsoft.gym.service.auth;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pinsoft.gym.dto.AuthenticationRequest;
import com.pinsoft.gym.dto.AuthenticationResponse;
import com.pinsoft.gym.dto.RegisterRequest;
import com.pinsoft.gym.enums.Role;
import com.pinsoft.gym.model.User;
import com.pinsoft.gym.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
	
	 private final UserRepository repository;
	 private final PasswordEncoder passwordEncoder;
	 private final JwtServiceImpl jwtServiceImpl;
	 private final AuthenticationManager authenticationManager;
	
	@Override
	public AuthenticationResponse register(RegisterRequest request) {
		User user=new User(request.getUsername(),
				passwordEncoder.encode(request.getPassword()),
				request.getFirstName(),
				request.getLastName());
		user.setRole(Role.USER);
		user.setAddress(request.getFirstName()+"address");
		user.setPhone(request.getFirstName()+"phone");
				
		
		repository.save(user);
		
		String jwtToken=jwtServiceImpl.generateToken(user);
		
		User inDB=repository.findByUsername(request.getUsername()).orElseThrow();
		
		return AuthenticationResponse.builder()
                .token(jwtToken)
                .userId(inDB.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
	}

	@Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        
        User inDB=repository.findByUsername(request.getUsername()).orElseThrow();

        String jwtToken = jwtServiceImpl.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userId(inDB.getId())
                .username(user.getUsername())
                .role(inDB.getRole())
                .build();
    }

	@Override
	public AuthenticationResponse adminRegister(RegisterRequest request) {
		User user=new User(request.getUsername(),
				passwordEncoder.encode(request.getPassword()),
				request.getFirstName(),
				request.getLastName());
		user.setRole(Role.ADMIN);
		user.setAddress(request.getFirstName()+"address");
		user.setPhone(request.getFirstName()+"phone");
				
		repository.save(user);
		
		String jwtToken=jwtServiceImpl.generateToken(user);
		
		User inDB=repository.findByUsername(request.getUsername()).orElseThrow();
		
		return AuthenticationResponse.builder()
                .token(jwtToken)
                .userId(inDB.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
		
	}

}
