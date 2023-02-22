package com.pinsoft.gym.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinsoft.gym.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findById(int id);

	Optional<User> findByUsername(String username);
	

}
