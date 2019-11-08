package com.base.app.application.web.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.base.app.application.core.entity.Client;
import com.base.app.application.core.service.ClientService;
import com.base.app.application.web.adapter.ClientAdapter;
import com.base.app.application.web.component.datatable.DataTableRequest;
import com.base.app.application.web.component.datatable.DataTableResults;
import com.base.app.application.web.component.datatable.DataTableUtil;
import com.base.app.application.web.component.datatable.PaginationCriteria;
import com.base.app.application.web.constants.DataTableConstants;
import com.base.app.application.web.controller.dto.ClientDto;

import lombok.extern.slf4j.Slf4j;

@Component(value="clientAdapter")
@Slf4j
public class ClientAdapterImpl implements ClientAdapter {
	
	private final ClientService ClientService;
	
	@Autowired
	public ClientAdapterImpl(ClientService ClientService) {
		this.ClientService = ClientService;
	}
	
	@Override
	public String getList(DataTableRequest<Client> dataTableInRQ) {
		log.info("METHOD: getList() -> ClientAdapterImpl");
		PaginationCriteria pagination = dataTableInRQ.getPaginationRequest();
		String orderby = pagination.getOrderByClause();
		String[] orderbySplit = orderby.split(" ");
		String camp;
		switch (orderbySplit[3]) {
		case DataTableConstants.CLIENT_ID:
			camp = "id";
			break;
		case DataTableConstants.CLIENT_NAME:
			camp = "name";
			break;
		case DataTableConstants.CLIENT_SURNAME:
			camp = "surname";
			break;
		case DataTableConstants.CLIENT_MAIL:
			camp = "mail";
			break;
		default:
			camp = orderbySplit[3];
			break;
		}
		PageRequest pageRequest = PageRequest.of(dataTableInRQ.getPageNumber(), pagination.getPageSize(), Direction.valueOf(orderbySplit[4]), camp);
		Page<Client> ClientList = this.ClientService.getList(new Client(), pageRequest);
		List<ClientDto> list = new ArrayList<>();
		for(Client Client : ClientList.getContent()) {
			list.add(new ClientDto(Client));
		}
		DataTableResults<ClientDto> dataTableResult = new DataTableResults<ClientDto>();
		log.info("END: getList() -> ClientAdapterImpl");
		return DataTableUtil.getDataTableResultsToJson(ClientList, list, dataTableInRQ, dataTableResult);
	}

}