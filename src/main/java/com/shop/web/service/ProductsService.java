package com.shop.web.service;

import java.util.List;

import com.shop.web.service.dto.ProductDTO;

public interface ProductsService {

	List<ProductDTO> getProducts();
	
	ProductDTO insert(ProductDTO productDTO);
	
	ProductDTO update(Long id, ProductDTO productDTO);
	
	void delete(Long id);
	
}
