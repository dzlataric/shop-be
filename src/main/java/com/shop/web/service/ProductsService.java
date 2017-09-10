package com.shop.web.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.shop.web.dto.ProductDTO;
import com.shop.web.dto.ProductDetailsDTO;

public interface ProductsService {

	@PreAuthorize("hasAuthority('ROLE_USER')")
	List<ProductDTO> getProducts(int page, int pageSize, String name);
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	ProductDetailsDTO getProductDetails(Long productId);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	ProductDTO insert(ProductDTO productDTO);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	ProductDTO update(Long id, ProductDTO productDTO);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	void delete(Long id);
	
}
