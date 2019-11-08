package com.base.app.application.web.controller.view;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.app.application.web.constants.RequestMappingConstants;
import com.base.app.application.web.constants.ViewConstants;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(RequestMappingConstants.LOGIN)
public class LoginController {

	/**
     * 	Index de la pagina /login
	 * @throws IOException 
     * 
     */
	@GetMapping()
	public ModelAndView login(Model model, String error, String logout, String expired, HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.info("METHOD: login() -> LoginController");
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if(SecurityConstants.ANONYMOUS_USER.equals(auth.getPrincipal().toString())) {
//			log.info("Returning to " + ViewConstants.LOGIN + " view");
			return new ModelAndView(ViewConstants.LOGIN);
//		} else {
//			log.info("Returning to " + ViewConstants.MAIN + " view");
//			return new ModelAndView(new RedirectView(RequestMappingConstants.MAIN, true));
//		}
	}

}