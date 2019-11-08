package com.base.app.application.web.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.app.application.web.constants.RequestMappingConstants;
import com.base.app.application.web.constants.ViewConstants;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(RequestMappingConstants.MAIN)
public class MainController {

	@GetMapping
	public ModelAndView index() {
		log.info("METHOD: index() -> MainController");
		ModelAndView mav = new ModelAndView(ViewConstants.MAIN);
		log.info("Returning to " + ViewConstants.MAIN + " view");			
		return mav;
	}

}