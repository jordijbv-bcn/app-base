package com.base.app.application.web.adapter;

import com.base.app.application.core.entity.Client;
import com.base.app.application.web.component.datatable.DataTableRequest;

public interface ClientAdapter {
			
	String getList(DataTableRequest<Client> dataTableInRQ);
	
}