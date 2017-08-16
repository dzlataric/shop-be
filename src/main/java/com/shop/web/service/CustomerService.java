package com.shop.web.service;

import com.shop.web.service.dto.CustomerDTO;

public interface CustomerService {
	
	CustomerDTO insert(CustomerDTO customerDTO);
	
	CustomerDTO update(Long id, CustomerDTO customerDTO);
	
	void delete(Long id);

}
