package com.shop.web.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.shop.web.dto.OrderItemDTO;

public interface OrderService {

	@PreAuthorize("hasAuthority('ROLE_USER')")
	void insert(String username, List<OrderItemDTO> orders);

}
