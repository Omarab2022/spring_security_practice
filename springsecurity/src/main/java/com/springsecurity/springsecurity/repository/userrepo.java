package com.springsecurity.springsecurity.repository;

import com.springsecurity.springsecurity.model.ouruser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface userrepo extends JpaRepository<ouruser, Integer> {

	@Query(value = "Select * from USERS where email = ?1", nativeQuery = true)
	Optional<ouruser> findbyemail(String email);
}
