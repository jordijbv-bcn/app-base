package com.base.app.application.web.adapter.impl;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.app.application.core.entity.Role;
import com.base.app.application.core.entity.User;
import com.base.app.application.core.service.UserService;
import com.base.app.application.web.adapter.UserAdapter;
import com.base.app.application.web.constants.WebConstants;
import com.base.app.application.web.controller.dto.UserDto;
import com.base.app.application.web.utils.AppUtils;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Component()
@Slf4j
public class UserAdapterImpl implements UserAdapter{

	private final UserService userService;

	@Autowired
	public UserAdapterImpl(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public List<User> getAll() {
		log.info("METHOD: getAll() by UserAdapterImpl");
		return this.userService.getAll();
	}
	
	@Override
	public UserDto getById(int id) throws NotFoundException {
		log.info("METHOD: getUserById() by UserAdapterImpl");
		User user = this.userService.find(id);
		return new UserDto(user);
	}

	@Override
	public void deleteById(int id) throws NotFoundException {
		log.info("METHOD: deleteById() by UserAdapterImpl");
		this.userService.delete(id);		
	}

	@Override
	public void deleteAll() {
		log.info("METHOD: deleteAll() by UserAdapterImpl");
		this.userService.deleteAll();
	}

	@Override
	public void update(int id, UserDto userDto) throws NotFoundException, ParseException {
		log.info("METHOD: update() by UserAdapterImpl");
		User user = this.userService.find(id);
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setBirthdate(AppUtils.stringToDate(userDto.getBirthdate(), WebConstants.FORMAT_COMPLETE_DATE));
		this.userService.update(user);
	}

	@Override
	public User createUser(UserDto userDto) throws ParseException {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPhone(userDto.getPhone());
		user.setBirthdate(AppUtils.stringToDate(userDto.getBirthdate(), WebConstants.FORMAT_COMPLETE_DATE));
		user.setPassword(AppUtils.passwordEncoder("test"));
		user.setRoles(Arrays.asList(new Role[]{new Role(3)}));
		return this.userService.create(user);
	}

}
