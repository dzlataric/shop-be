package com.shop.web.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.shop.web.dto.OrderItemDTO;
import com.shop.web.dto.OrdersDTO;
import com.shop.web.entity.CustomerOrder;
import com.shop.web.exception.ServiceCommunicationException;

/**
 * @author Dejan Zlatarić RA158-2011
 */
public interface OrderService {

	/**
	 * Insert new order.
	 *
	 * @param username the customer username
	 * @param orders the orders to create
	 * @throws ServiceCommunicationException 
	 */
	@PreAuthorize("hasAuthority('ROLE_USER')")
	void insert(String username, List<OrderItemDTO> orders) throws ServiceCommunicationException;

	/**
	 * Find all orders.
	 *
	 * @return the list of all created orders
	 */
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	List<CustomerOrder> findAllOrders();
	
	List<OrdersDTO> forReport();
}
