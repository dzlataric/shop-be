package com.shop.web.service.impl;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.shop.web.dto.CustomerDTO;
import com.shop.web.entity.UserCredentials;
import com.shop.web.entity.Customer;
import com.shop.web.repository.CustomerRepository;
import com.shop.web.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Inject
	private CustomerRepository customerRepository;

	@Override
	public void insert(CustomerDTO customerDTO) {
		
		Customer customer = new Customer().withFirstName(customerDTO.getFirstName())
				.withLastName(customerDTO.getLastName()).withAddress(customerDTO.getAddress())
				.withCity(customerDTO.getCity()).withCountry(customerDTO.getCountry())
				.withGender(customerDTO.getGender());
		customerRepository.save(customer);
	}

	@Override
	public void update(Long id, CustomerDTO customerDTO) {
		Customer toUpdate = customerRepository.findOne(id);
		if (toUpdate == null) {
			throw new EntityNotFoundException("Customer not found!");
		}

		customerRepository.save(
				toUpdate.withId(id).withFirstName(customerDTO.getFirstName()).withLastName(customerDTO.getLastName())
						.withAddress(customerDTO.getAddress()).withCity(customerDTO.getCity())
						.withCountry(customerDTO.getCountry()).withGender(customerDTO.getGender()));

	}

	@Override
	public void delete(Long id) {
		customerRepository.delete(id);
	}

}
