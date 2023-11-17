package com.springsecurity.springsecurity.controller;


import com.springsecurity.springsecurity.model.ouruser;
import com.springsecurity.springsecurity.repository.productrepo;
import com.springsecurity.springsecurity.repository.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class controller {

	@Autowired
	private userrepo ourUserRepo;
	@Autowired
	private productrepo productRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String goH0me(){
		return "Thisn is publickly accesible withing needing authentication ";
	}


	@PostMapping("/user/save")
	public ResponseEntity<Object> saveUSer(@RequestBody ouruser ourUser){
		ourUser.setPassword(passwordEncoder.encode(ourUser.getPassword()));
		ouruser result = ourUserRepo.save(ourUser);
		if (result.getId() > 0){
			return ResponseEntity.ok("USer Was Saved");
		}
		return ResponseEntity.status(404).body("Error, USer Not Saved");
	}


	@GetMapping("/product/all")
	public ResponseEntity<Object> getAllProducts(){
		return ResponseEntity.ok(productRepo.findAll());
	}


	@GetMapping("/users/all")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Object> getAllUSers(){
		return ResponseEntity.ok(ourUserRepo.findAll());
	}



	@GetMapping("/users/single")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public ResponseEntity<Object> getMyDetails(){
		return ResponseEntity.ok(ourUserRepo.findbyemail(getLoggedInUserDetails().getUsername()));
	}

	public UserDetails getLoggedInUserDetails(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
			return (UserDetails) authentication.getPrincipal();
		}
		return null;
	}
}
