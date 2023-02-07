package com.pinsoft.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinsoft.gym.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findById(int id);
	

}
