package com.pinsoft.gym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
}
