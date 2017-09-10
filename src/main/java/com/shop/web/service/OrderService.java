package com.shop.web.service;

import org.springframework.security.access.prepost.PreAuthorize;

import com.shop.web.dto.OrderDTO;

public interface OrderService {

	@PreAuthorize("hasAuthority('ROLE_USER')")
	void insert(OrderDTO order);
	
}
