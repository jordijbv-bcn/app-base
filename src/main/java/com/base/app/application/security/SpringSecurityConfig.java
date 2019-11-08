package com.base.app.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.base.app.application.core.service.impl.JpaUserDetailsService;
import com.base.app.application.web.constants.RequestMappingConstants;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService jpaUserDetailsService;
	
	@Autowired	
	private LoginSuccessHandler loginSuccessHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.authorizeRequests()
			.antMatchers(RequestMappingConstants.LOGIN + "/**", "/images/**", "/css/**", "/js/**", "/resources/**", "/fonts/**").permitAll()
			.antMatchers("/**").authenticated()
			.and().formLogin().successHandler(loginSuccessHandler).loginPage(RequestMappingConstants.LOGIN).permitAll()		
			.and().logout().permitAll()
			.and().exceptionHandling().authenticationEntryPoint(new AjaxAwareAuthenticationEntryPoint(RequestMappingConstants.LOGIN_EXPIRED));		
		http.headers().frameOptions().sameOrigin().httpStrictTransportSecurity().disable();	
		http.csrf().disable();
	}	

	 @Bean
	 public SessionRegistry sessionRegistry() {
	     SessionRegistry sessionRegistry = new SessionRegistryImpl();
	     return sessionRegistry;
	 }
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(jpaUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}	

}
