package com.shop.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shop.web.dto.OrderItemDTO;
import com.shop.web.dto.OrdersDTO;
import com.shop.web.dto.PaymentDetailsDTO;
import com.shop.web.entity.Customer;
import com.shop.web.entity.CustomerOrder;
import com.shop.web.entity.OrderDetails;
import com.shop.web.entity.Product;
import com.shop.web.exception.ServiceCommunicationException;
import com.shop.web.repository.CustomerRepository;
import com.shop.web.repository.OrderRepository;
import com.shop.web.repository.ProductRepository;
import com.shop.web.service.OrderService;
import com.shop.web.service.PaymentValidatorService;

@Service
public class OrderServiceImpl implements OrderService {

	@Inject
	private OrderRepository orderRepository;
	@Inject
	private CustomerRepository customerRepository;
	@Inject
	private ProductRepository productRepository;

	@Override
	@Transactional
	public void insert(final String username, final List<OrderItemDTO> orders) throws ServiceCommunicationException {
		final Customer customer = customerRepository.findByUsername(username);
		final CustomerOrder customerOrder = new CustomerOrder().withCustomer(customer).withOrderDate(new Date());
		final Set<OrderDetails> orderDetails = orders.stream()
				.map(order -> new OrderDetails().withProduct(productRepository.findOne(order.getProductId()))
						.withAmount(order.getAmount()).withOrder(customerOrder))
				.collect(Collectors.toSet());
		orderRepository.save(customerOrder.withOrderDetails(orderDetails));
		List<OrderDetails> ordersAmount = new ArrayList<>(orderDetails);
		ordersAmount.stream().forEach(ord -> {
			Product p = ord.getProduct();
			p.setStock(p.getStock() -  ord.getAmount());
			productRepository.save(p);
		});
	}

	@Override
	public List<CustomerOrder> findAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public List<OrdersDTO> forReport() {
		List<CustomerOrder> orders = findAllOrders();
		List<OrdersDTO> ords = new ArrayList<>();
		for (int i = 0; i < orders.size(); i++) {
			Customer customer = orders.get(i).getCustomer();
			List<OrderDetails> orderDetails = new ArrayList<>(orders.get(i).getOrderDetails());
			for (int j = 0; j < orderDetails.size(); j++) {
				OrdersDTO order = new OrdersDTO(customer.getFirstName(), customer.getLastName(), "26-10-2017",
						orderDetails.get(j).getProduct().getName(), orderDetails.get(j).getAmount().longValue(),
						productRepository.getOne(orderDetails.get(j).getProduct().getId()).getPrice());
				ords.add(order);
			}
		}
		return ords;
	}
}
