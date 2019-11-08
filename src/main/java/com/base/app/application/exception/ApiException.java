package com.base.app.application.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiException extends Exception {

	private static final long serialVersionUID = -8279779319928073287L;
	
	private final HttpStatus statusCode;

    public ApiException(String msg, HttpStatus statusCode) {
        super(msg);
        this.statusCode = statusCode;
    }
    
}
