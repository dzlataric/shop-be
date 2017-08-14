package com.shop.web.service;

import com.shop.web.entity.Customer;

public interface CustomerService {
	
	void insert(Customer customer);
	
	void delete(Long id);

}
