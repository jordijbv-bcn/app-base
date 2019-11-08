package com.base.app.application.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.app.application.core.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>  {
		
	User findByEmail(String email);
	
}