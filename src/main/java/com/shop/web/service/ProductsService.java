package com.shop.web.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.shop.web.dto.ProductDTO;
import com.shop.web.dto.ProductDetailsDTO;

/**
 * @author Dejan Zlatarić RA158-2011
 */
public interface ProductsService {
	/**
	 * Gets the list of products.
	 *
	 * @param page the page number
	 * @param pageSize the number of elements per page
	 * @param name the search parameter
	 * @return the list of products
	 */
	@PreAuthorize("hasAuthority('ROLE_USER')")
	List<ProductDTO> getProducts(int page, int pageSize, String name);
	/**
	 * Gets the product details.
	 *
	 * @param productId the product id
	 * @return the product details
	 */
	@PreAuthorize("hasAuthority('ROLE_USER')")
	ProductDetailsDTO getProductDetails(Long productId);
	/**
	 * Insert product.
	 *
	 * @param productDTO the product object
	 */
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	void insert(ProductDTO productDTO);
	/**
	 * Delete product.
	 *
	 * @param id the product id
	 */
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	void delete(Long id);
}
