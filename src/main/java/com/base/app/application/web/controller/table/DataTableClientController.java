package com.base.app.application.web.controller.table;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.app.application.core.entity.Client;
import com.base.app.application.web.adapter.ClientAdapter;
import com.base.app.application.web.component.datatable.DataTableRequest;
import com.base.app.application.web.constants.RequestMappingConstants;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DataTableClientController {	
	
	@Qualifier("clientAdapter")
	private final ClientAdapter clientAdapter;
	
	@Autowired
	public DataTableClientController(ClientAdapter clientAdapter) {
		this.clientAdapter = clientAdapter;
	}
	
	@GetMapping(value = RequestMappingConstants.CLIENT)
	@ResponseBody
	public String getList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("METHOD: getList() -> DataTableExampleController");
		String result = this.clientAdapter.getList(new DataTableRequest<Client>(request));	
		log.info("END: getList() -> DataTableExampleController");
		return result;
	}
	
}