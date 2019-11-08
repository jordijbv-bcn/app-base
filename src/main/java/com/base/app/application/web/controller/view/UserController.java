package com.base.app.application.web.controller.view;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.app.application.web.constants.RequestMappingConstants;
import com.base.app.application.web.constants.ViewConstants;
import com.base.app.application.web.utils.AppResources;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(RequestMappingConstants.USER)
public class UserController {

//	private final UserAdapter userAdapter;
//
//	@Autowired
//	public UserController(UserAdapter userAdapter) {
//		this.userAdapter = userAdapter;
//	}
	
	@GetMapping
	public ModelAndView index() {
		log.info("METHOD: index() by UserController");
		ModelAndView mav = new ModelAndView(ViewConstants.USER_INDEX);
		mav.addObject("pageTitle", AppResources.getResource("msg.usuari.index.menu", LocaleContextHolder.getLocale()));
		return mav;		
	}

}
