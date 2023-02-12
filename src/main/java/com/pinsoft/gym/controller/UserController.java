package com.pinsoft.gym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinsoft.gym.dto.UserDto;
import com.pinsoft.gym.model.User;
import com.pinsoft.gym.service.UserServiceImpl;
import com.pinsoft.gym.shared.GenericResponse;

@RestController
@RequestMapping("/GYM")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/user/{id}")
	User getById(@PathVariable int id) {
		return this.userService.getById(id);
	}
	@GetMapping("/user/getall")
	List<UserDto> getAll(){
		List<User> userList=this.userService.getAll();
		List<UserDto> userDtoList=new ArrayList<UserDto>();
		for (User user : userList) {
			UserDto userDto=new UserDto();
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setAddress(user.getAddress());
			userDto.setPhone(user.getPhone());
			userDtoList.add(userDto);
		}
		return userDtoList;
	}
	@PostMapping("/user/add")
	GenericResponse save(@RequestBody User user) {
		this.userService.save(user);
		return new GenericResponse("Kullanıcı Eklendi");
	}
	@DeleteMapping("/user/delete")
	GenericResponse delete(@RequestParam int id) {
		this.userService.delete(id);
		return new GenericResponse("Kullanıcı Silindi");
	}
	@PutMapping("/user/{id}/update")
	GenericResponse update(@PathVariable int id,@RequestBody User user) {
		this.userService.update(id, user);
		return new GenericResponse("Kullanıcı Bilgisi Güncellendi");
	}
}
