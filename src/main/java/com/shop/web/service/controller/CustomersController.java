package com.shop.web.service.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.web.service.CustomerService;
import com.shop.web.service.dto.CustomerDTO;

@RestController
@RequestMapping(value = CustomersController.BASE_REQUEST_MAPPING)
public class CustomersController {

	protected static final String BASE_REQUEST_MAPPING = "/customers";

	@Inject
	private CustomerService customerService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	private ResponseEntity<CustomerDTO> createProduct(@RequestBody final CustomerDTO customer) {
		return new ResponseEntity<CustomerDTO>(customerService.insert(customer), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	private ResponseEntity<CustomerDTO> updateProduct(@PathVariable(value = "id") final Long id,
			@RequestBody final CustomerDTO customer) {
		return new ResponseEntity<CustomerDTO>(customerService.update(id, customer), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteProduct(@PathVariable(value = "id") final Long id) {
		customerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
