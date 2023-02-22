package com.pinsoft.gym.dto;

import com.pinsoft.gym.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	private String token;
	private Integer userId;
	private String username;
	private Role role;
}
