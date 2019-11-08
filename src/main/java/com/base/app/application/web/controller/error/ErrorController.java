package com.base.app.application.web.controller.error;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.base.app.application.web.constants.ViewConstants;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice 
public class ErrorController {

	/**
     * 	Captura el error 500 -> Internal Server Error.
     * 
     */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleAllException(Exception ex) {
		log.info("METHOD: handleAllException() -> ErrorController");
		log.error("Error INTERNAL_SERVER_ERROR 500", ex);
		return new ModelAndView(ViewConstants.ERROR_VIEW_500);
	}

	/**
     * 	Captura el error 403 -> Permis Denegat.
     * 
     */
	@ExceptionHandler(AccessDeniedException.class)
	public ModelAndView accessDenied() {
		log.info("METHOD: accessDenied() -> ErrorController");
		log.error("Error 403: Access Denied or Prohibited");
		return new ModelAndView(ViewConstants.ERROR_VIEW_403);
	}
	
	@ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
	public ModelAndView notFound() {
		log.info("METHOD: notFound() -> ErrorController");
		log.error("Error 404: Access Denied or Prohibited");
		return new ModelAndView(ViewConstants.ERROR_VIEW_404);
	}

}