package com.shop.web.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shop.web.entity.Product;
import com.shop.web.repository.ProductRepository;
import com.shop.web.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductRepository productRepository;
	
	@Override
	public void insert(Product product) {
		productRepository.save(product);
	}

	@Override
	public void delete(Long id) {
		productRepository.delete(id);
	}

}
