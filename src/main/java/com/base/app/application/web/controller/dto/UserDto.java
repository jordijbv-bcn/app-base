package com.base.app.application.web.controller.dto;

import com.base.app.application.core.entity.User;
import com.base.app.application.web.utils.AppUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	
	private int id;

	private String email;
    
	private String firstName;
   
	private String lastName;
    
	private String birthdate;
	
	private int phone;

	public UserDto(User user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.birthdate = AppUtils.DateToString(user.getBirthdate());
		this.phone = user.getPhone();
	}

}
