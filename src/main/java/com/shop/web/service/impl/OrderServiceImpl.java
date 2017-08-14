package com.shop.web.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shop.web.entity.CustomerOrder;
import com.shop.web.repository.OrderRepository;
import com.shop.web.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Inject
	private OrderRepository orderRepository;
	
	@Override
	public void insert(CustomerOrder order) {
		orderRepository.save(order);
	}

	@Override
	public void delete(Long id) {
		orderRepository.delete(id);
	}

}
