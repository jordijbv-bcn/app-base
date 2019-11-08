package com.base.app.application.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.base.app.application.core.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>, JpaSpecificationExecutor<Client>  {
	
}