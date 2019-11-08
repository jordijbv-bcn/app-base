package com.base.app.application.web.adapter;

import java.text.ParseException;
import java.util.List;

import com.base.app.application.core.entity.User;
import com.base.app.application.web.controller.dto.UserDto;

import javassist.NotFoundException;

public interface UserAdapter {
			
	List<User> getAll();
	
	UserDto getById(int id) throws NotFoundException;
	
	void deleteById(int id) throws NotFoundException;
	
	void deleteAll();
	
	void update(int id, UserDto userDto) throws NotFoundException, ParseException;

	User createUser(UserDto userDto) throws ParseException;
	
}
