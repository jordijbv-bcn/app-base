package com.base.app.application.web.controller.dto;

import com.base.app.application.core.entity.Client;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDto {

	private Long id;
	
	private String name;
	
	private String surname;
	
	private String mail;

	public ClientDto(Client client) {
		super();
		this.id = client.getId();
		this.name = client.getName();
		this.surname = client.getSurname();
		this.mail = client.getMail();
	}

}