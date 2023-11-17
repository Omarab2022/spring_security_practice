package com.springsecurity.springsecurity.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;

}
