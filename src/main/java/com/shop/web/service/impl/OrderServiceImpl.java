package com.shop.web.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shop.web.dto.OrderItemDTO;
import com.shop.web.entity.Customer;
import com.shop.web.entity.CustomerOrder;
import com.shop.web.entity.OrderDetails;
import com.shop.web.repository.CustomerRepository;
import com.shop.web.repository.OrderRepository;
import com.shop.web.repository.ProductRepository;
import com.shop.web.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Inject
	private OrderRepository orderRepository;

	@Inject
	private CustomerRepository customerRepository;

	@Inject
	private ProductRepository productRepository;

	@Override
	public void insert(final String username, final List<OrderItemDTO> orders) {
		final Customer customer = customerRepository.findByUsername(username);
		final CustomerOrder customerOrder = new CustomerOrder().withCustomer(customer).withOrderDate(new Date());
		final Set<OrderDetails> orderDetails = orders.stream()
				.map(order -> new OrderDetails().withProduct(productRepository.findOne(order.getProductId()))
						.withAmount(order.getAmount()).withOrder(customerOrder))
				.collect(Collectors.toSet());
		orderRepository.save(customerOrder.withOrderDetails(orderDetails));
	}

}
