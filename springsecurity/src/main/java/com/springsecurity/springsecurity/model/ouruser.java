package com.springsecurity.springsecurity.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class ouruser {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String email;

	private String password;

	private String roles ;


}
