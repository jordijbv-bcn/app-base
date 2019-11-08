package com.base.app.application.web.controller.rest;

import java.net.URI;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.base.app.application.core.entity.User;
import com.base.app.application.web.adapter.UserAdapter;
import com.base.app.application.web.constants.RestMappingConstants;
import com.base.app.application.web.controller.dto.UserDto;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@Slf4j
@RequestMapping(RestMappingConstants.API_REST + RestMappingConstants.USER)
public class UserRestController {

	private final UserAdapter userAdapter;

	@Autowired
	public UserRestController(UserAdapter userAdapter) {
		this.userAdapter = userAdapter;
	}
	
	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto) throws ParseException {
		log.info("METHOD: createUser() by UserRestController");
		User user = this.userAdapter.createUser(userDto);
		if (user == null) {
			return ResponseEntity.notFound().build();
		} else {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
			return ResponseEntity.created(uri).body(new UserDto(user));
		}
	}

	@GetMapping(value = RestMappingConstants.USER_ID)
	public ResponseEntity<?> getById(@PathVariable int id) {
		log.info("METHOD: getUserById() by UserRestController");
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.userAdapter.getById(id));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = RestMappingConstants.USER_ID)
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody UserDto userDto) {
		log.info("METHOD: getUserById() by UserRestController");
		log.info("INFO: userDto -> " + userDto.toString());
		try {
			this.userAdapter.update(id, userDto);
			return ResponseEntity.noContent().build();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}	
	}
	
	@DeleteMapping(value = RestMappingConstants.USER_ID)
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		log.info("METHOD: deleteById() by UserRestController");
		try {
			this.userAdapter.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping()
	public  ResponseEntity<?> getAll() {
		log.info("METHOD: getAll() by UserRestController");
		return ResponseEntity.status(HttpStatus.OK).body(this.userAdapter.getAll());
	}
	
	@DeleteMapping()
	public  ResponseEntity<?> deleteAll() {
		log.info("METHOD: deleteAll() by UserRestController");
		this.userAdapter.deleteAll();
		return ResponseEntity.noContent().build();
	}

}
