package com.base.app.application.web.controller.locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.app.application.web.constants.RequestMappingConstants;

@Controller
@RequestMapping(RequestMappingConstants.LOCALE)
public class LocaleController {

	@GetMapping()
	public String locale(HttpServletRequest request) {
		return "redirect:".concat(request.getHeader("referer"));
	}

}