package com.shop.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.web.dto.OrderItemDTO;
import com.shop.web.service.OrderService;

@RestController
@RequestMapping(value = ShoppingCartController.BASE_REQUEST_MAPPING)
public class ShoppingCartController {

	protected static final String BASE_REQUEST_MAPPING = "/checkout";

	@Inject
	private OrderService orderService;

	@RequestMapping(value = "/{username}", method = RequestMethod.POST)
	private ResponseEntity<String> placeOrder(@PathVariable(value = "username") final String username,
			@RequestBody final List<OrderItemDTO> orders) {
		orderService.insert(username, orders);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
