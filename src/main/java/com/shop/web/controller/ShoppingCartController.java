package com.shop.web.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.web.dto.OrderDTO;
import com.shop.web.service.OrderService;

public class ShoppingCartController {

	@Inject
	private OrderService orderService;

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	private ResponseEntity<String> createProduct(@PathVariable(value = "id") final Long id,
			@RequestBody final OrderDTO orderDTO) {
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
