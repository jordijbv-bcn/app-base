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
@RequestMapping(RequestMappingConstants.TEST)
public class TestController {

	@GetMapping
	public ModelAndView index() {
		log.info("METHOD: index() -> TestController");
		ModelAndView mav = new ModelAndView(ViewConstants.TEST);
		mav.addObject("pageTitle", AppResources.getResource("msg.test.menu", LocaleContextHolder.getLocale()));
		log.info("Returning to " + ViewConstants.TEST + " view");			
		return mav;
	}

}