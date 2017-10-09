package com.shop.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.shop.web.dto.OrderItemDTO;
import com.shop.web.entity.CustomerOrder;

public interface OrderService {

	@PreAuthorize("hasAuthority('ROLE_USER')")
	void insert(String username, List<OrderItemDTO> orders);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	List<CustomerOrder> findAllOrdersInPeriod(Date from, Date to);

}
