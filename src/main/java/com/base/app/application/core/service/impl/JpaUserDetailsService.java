package com.base.app.application.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.app.application.core.entity.Role;
import com.base.app.application.core.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
		
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        com.base.app.application.core.entity.User user = this.userService.findByEmail(username);
        
        if(user == null) {
        	log.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
        	throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(Role role: user.getRoles()) {
        	log.info("Role: ".concat(role.getUserRole()));
        	authorities.add(new SimpleGrantedAuthority(role.getUserRole()));
        }
        
        if(authorities.isEmpty()) {
        	log.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
        	throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }
        
        return buildUser(user, authorities);
        
	}
	
	private User buildUser(com.base.app.application.core.entity.User user, List<GrantedAuthority> authorities) {
		try {
			return new User(user.getEmail(), user.getPassword(), true, true, true, true, authorities);
		} catch (Exception e) {
			log.error("Error: getUser", e);
		}
		return null;
	}

}
