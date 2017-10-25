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

import com.shop.web.dto.BasicEmailRequestDTO;
import com.shop.web.dto.OrderItemDTO;
import com.shop.web.dto.PaymentDetailsDTO;
import com.shop.web.exception.ServiceCommunicationException;
import com.shop.web.service.EmailService;
import com.shop.web.service.OrderService;
import com.shop.web.service.PaymentValidatorService;

@RestController
@RequestMapping(value = ShoppingCartController.BASE_REQUEST_MAPPING)
public class ShoppingCartController {

	protected static final String BASE_REQUEST_MAPPING = "/checkout";

	@Inject
	private OrderService orderService;
	
	@Inject
	private EmailService emailService;

	@Inject
	private PaymentValidatorService paymentValidatorService;
	
	@RequestMapping(value = "/{username}", method = RequestMethod.POST)
	private ResponseEntity<String> placeOrder(@PathVariable(value = "username") final String username,
			@RequestBody final List<OrderItemDTO> orders) throws ServiceCommunicationException {
		paymentValidatorService.validate(new PaymentDetailsDTO("1111-2222-3333", 1234L, 50.0));
		orderService.insert(username, orders);
		emailService.sendEmail(new BasicEmailRequestDTO("noreply@diplomski", "Order", "Order successfully created"));
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
