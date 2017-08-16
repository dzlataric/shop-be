package com.shop.web.service.impl;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.shop.web.entity.Customer;
import com.shop.web.repository.CustomerRepository;
import com.shop.web.service.CustomerService;
import com.shop.web.service.dto.CustomerDTO;
import com.shop.web.util.CustomerType;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Inject
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO insert(CustomerDTO customerDTO) {
		Customer customer = new Customer().withFirstName(customerDTO.getFirstName())
				.withLastName(customerDTO.getLastName()).withType(customerDTO.getType().name())
				.withAddress(customerDTO.getAddress()).withCity(customerDTO.getCity())
				.withCountry(customerDTO.getCountry()).withGender(customerDTO.getGender());
		Customer saved = customerRepository.save(customer);
		return new CustomerDTO(saved.getId(), saved.getFirstName(), saved.getLastName(),
				CustomerType.valueOf(saved.getType()), saved.getAddress(), saved.getCity(), saved.getCountry(),
				saved.getGender());
	}

	@Override
	public CustomerDTO update(Long id, CustomerDTO customerDTO) {
		Customer toUpdate = customerRepository.findOne(id);
		if (toUpdate == null) {
			throw new EntityNotFoundException("Customer not found!");
		}

		Customer updated = customerRepository.save(toUpdate.withId(id).withFirstName(customerDTO.getFirstName())
				.withLastName(customerDTO.getLastName()).withType(customerDTO.getType().name())
				.withAddress(customerDTO.getAddress()).withCity(customerDTO.getCity())
				.withCountry(customerDTO.getCountry()).withGender(customerDTO.getGender()));

		return new CustomerDTO(updated.getId(), updated.getFirstName(), updated.getLastName(),
				CustomerType.valueOf(updated.getType()), updated.getAddress(), updated.getCity(), updated.getCountry(),
				updated.getGender());
	}

	@Override
	public void delete(Long id) {
		customerRepository.delete(id);
	}

}
