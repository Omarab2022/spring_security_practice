package com.springsecurity.springsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class securityconfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeHttpRequests(auth -> auth
						.requestMatchers("/","/user/save","/product/all").permitAll()
						.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				.csrf(AbstractHttpConfigurer::disable);

		return httpSecurity.build();

	}

	@Bean
	public AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsservise());
		authenticationProvider.setPasswordEncoder(passwordencoder());
		return authenticationProvider;
	}


	@Bean
	public UserDetailsService userDetailsservise() {

		return new OurUserInfoUserDetailsService();
	}

	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}


}
