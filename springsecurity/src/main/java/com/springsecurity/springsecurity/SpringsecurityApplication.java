package com.springsecurity.springsecurity;

import com.springsecurity.springsecurity.model.ouruser;
import com.springsecurity.springsecurity.repository.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringsecurityApplication {

	@Autowired
	private userrepo userrepo ;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}




}

