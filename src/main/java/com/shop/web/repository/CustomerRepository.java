package com.shop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.web.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByUsername(String username);

}
