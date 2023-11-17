package com.springsecurity.springsecurity.config;

import com.springsecurity.springsecurity.model.ouruser;
import com.springsecurity.springsecurity.repository.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Configuration
public class OurUserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private userrepo ouruser;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<ouruser> user = ouruser.findbyemail(username);

		return user.map(OurUserInfoDetails::new).orElseThrow(()-> new UsernameNotFoundException("username not found !!"));
	}
}
