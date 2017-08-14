package com.shop.web.service;

import com.shop.web.entity.Product;

public interface ProductService {

	void insert(Product product);
	
	void delete(Long id);
	
}
