package com.shop.web.service;

import com.shop.web.entity.CustomerOrder;

public interface OrderService {

	void insert(CustomerOrder order);
	
	void delete(Long id);
	
}
