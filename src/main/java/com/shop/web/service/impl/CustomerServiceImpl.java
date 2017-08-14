package com.shop.web.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shop.web.entity.Customer;
import com.shop.web.repository.CustomerRepository;
import com.shop.web.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Inject
	private CustomerRepository customerRepository;
	
	@Override
	public void insert(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void delete(Long id) {
		customerRepository.delete(id);
	}

}
