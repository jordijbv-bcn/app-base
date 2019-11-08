package com.base.app.application.web.convert;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class testScript {

	public static void main(String[] args) {

		BCryptPasswordEncoder password = new BCryptPasswordEncoder();
		System.out.println(password.encode("admin"));

	}

}