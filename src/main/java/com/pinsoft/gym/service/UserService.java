package com.pinsoft.gym.service;

import java.util.List;

import com.pinsoft.gym.model.User;

public interface UserService {
	 User getById(int id);
	 List<User> getAll();
	 void save(User user);
	 void delete(int id);
	 User update(int id,User user);
}
