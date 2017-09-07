package com.shop.web.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shop.web.dto.OrderDTO;
import com.shop.web.entity.Customer;
import com.shop.web.entity.CustomerOrder;
import com.shop.web.entity.OrderDetails;
import com.shop.web.repository.OrderRepository;
import com.shop.web.repository.ProductRepository;
import com.shop.web.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Inject
	private OrderRepository orderRepository;
	
	@Inject
	private ProductRepository productRepository;
	
	
	@Override
	public void insert(OrderDTO order) {
		order.getProductIdsWithAmmount().forEach((key, value) -> {
			OrderDetails orderDetails = new OrderDetails().withProduct(productRepository.findOne(key)).withAmount(value);
		});
	}

}
