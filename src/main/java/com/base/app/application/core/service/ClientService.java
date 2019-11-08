package com.base.app.application.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.app.application.core.entity.Client;

public interface ClientService {

	Page<Client> getList(Client client, Pageable pageable);
	
}