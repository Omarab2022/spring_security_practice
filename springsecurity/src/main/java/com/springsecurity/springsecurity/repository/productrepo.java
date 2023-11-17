package com.springsecurity.springsecurity.repository;

import com.springsecurity.springsecurity.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface productrepo extends JpaRepository<product, Integer> {


}
