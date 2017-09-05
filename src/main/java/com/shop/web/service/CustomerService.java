package com.shop.web.service;

import com.shop.web.dto.CustomerDTO;

public interface CustomerService {
	
	void insert(CustomerDTO customerDTO);
	
	void update(Long id, CustomerDTO customerDTO);
	
	void delete(Long id);

}
