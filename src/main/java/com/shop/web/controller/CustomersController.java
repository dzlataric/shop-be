package com.shop.web.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.web.dto.CustomerDTO;
import com.shop.web.service.CustomerService;

@RestController
@RequestMapping(value = CustomersController.BASE_REQUEST_MAPPING)
public class CustomersController {

	protected static final String BASE_REQUEST_MAPPING = "/customers";

	@Inject
	private CustomerService customerService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	private ResponseEntity<String> createCustomer(@RequestBody final CustomerDTO customer) {
		customerService.insert(customer);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	private ResponseEntity<String> updateCustomer(@PathVariable(value = "id") final Long id,
			@RequestBody final CustomerDTO customer) {
		customerService.update(id, customer);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") final Long id) {
		customerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
