package com.pinsoft.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinsoft.gym.model.User;
import com.pinsoft.gym.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	
	public User getById(int id) {
		return this.userRepository.findById(id);
	}
	
	public List<User> getAll(){
		return this.userRepository.findAll();
	}
	
	public void save(User user) {
		this.userRepository.save(user);
	}
	
	public void delete(int id) {
		this.userRepository.deleteById(id);
	}
	
	public User update(int id,User user) {
		User userInDB=userRepository.findById(id);
		userInDB.setFirstName(user.getFirstName());
		userInDB.setLastName(user.getLastName());
		userInDB.setAddress(user.getAddress());
		userInDB.setPhone(user.getPhone());
		return userRepository.save(userInDB);
	}
}
