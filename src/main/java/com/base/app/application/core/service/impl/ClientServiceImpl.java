package com.base.app.application.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.app.application.core.entity.Client;
import com.base.app.application.core.repository.ClientRepository;
import com.base.app.application.core.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	private final ClientRepository exampleRepository;
		
	@Autowired
	public ClientServiceImpl(ClientRepository exampleRepository) {		
		this.exampleRepository = exampleRepository;
	}

	@Override
	public Page<Client> getList(Client client, Pageable pageable) {
		return this.exampleRepository.findAll(pageable);
	}
	
}