package com.base.app.application.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.base.app.application.core.entity.User;
import com.base.app.application.exception.ApiException;

import javassist.NotFoundException;

public interface UserService {
	
	/** STANDARD CALLS **/
	
	/**
	 * Create a User resource.
	 * 
	 * @param object The data object.
	 */
	User create(User user);

	/**
	 * Update a User resource.
	 *
	 * @param object The data object.
	 */
	void update(User user);

	/**
	 * Delete a User resource.
	 * 
	 * @param id Identifier.
	 * @throws NotFoundException 
	 */
	void delete(int id) throws NotFoundException;
	
	/**
	 * Delete all user resources.
	 * 
	 */
	void deleteAll();

	/**
	 * Get a User resource. If not exists return null.
	 * 
	 * @param id Identifier
	 * @return the data object.
	 */
	public User search(int id);

	/**
	 * Get a User resource. If not exists throw an Exception.
	 * 
	 * @param id Identifier
	 * @return the data object.
	 * @throws ApiException 
	 * @throws NotFoundException 
	 */
	public User find(int id) throws NotFoundException;

	/**
	 * Get a list of all resources.
	 * 
	 * @return A list with the resources found.
	 */
	public List<User> getAll();

	/**
	 * Get a list of resources by Pageable.
	 * 
	 * @return A list with the resources found.
	 */
	public List<User> getAll(Pageable pageable);

	/**
	 * Check if an entity exists.
	 * 
	 * @param id Identifier.
	 * @return True if it exists.
	 */
	boolean exists(int id);
	
	/** SPECIFIC CALLS **/
	
	public User findByEmail(String email);
	
}