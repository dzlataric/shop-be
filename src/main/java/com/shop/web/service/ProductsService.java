package com.shop.web.service;

import java.util.List;

import com.shop.web.dto.ProductDTO;

public interface ProductsService {

	List<ProductDTO> getProducts(int page, int pageSize, String name);
	
	ProductDTO insert(ProductDTO productDTO);
	
	ProductDTO update(Long id, ProductDTO productDTO);
	
	void delete(Long id);
	
}
