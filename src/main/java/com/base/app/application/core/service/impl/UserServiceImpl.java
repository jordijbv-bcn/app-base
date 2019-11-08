package com.base.app.application.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.app.application.core.entity.User;
import com.base.app.application.core.repository.UserRepository;
import com.base.app.application.core.service.UserService;

import javassist.NotFoundException;


@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/** STANDARD CALLS **/
	
	@Override
	public User create(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public void update(User user) {
		this.userRepository.save(user);
	}

	@Override
	public void delete(int id) throws NotFoundException {
		User user = this.userRepository.findById(id).orElseThrow(() -> new NotFoundException("Error"));
		this.userRepository.delete(user);
	}
	
	@Override
	public void deleteAll() {
		this.userRepository.deleteAll();
	}

	@Override
	public User search(int id) {
		return this.userRepository.findById(id).orElse(null);
	}

	@Override
	public User find(int id) throws NotFoundException {
		return this.userRepository.findById(id).orElseThrow(() -> new NotFoundException("Error"));
	}

	@Override
	public List<User> getAll() {
		return this.userRepository.findAll();
	}
	
	@Override
	public List<User> getAll(Pageable pageable) {
		return this.userRepository.findAll(pageable).getContent();
	}

	@Override
	public boolean exists(int id) {
		return this.userRepository.findById(id).isPresent();
	}
	
	/** SPECIFIC CALLS **/
	
	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

}
