package com.shop.web.controller;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.web.dto.ProductDTO;
import com.shop.web.dto.ProductDetailsDTO;
import com.shop.web.service.ProductsService;

@RestController
@RequestMapping(value = ProductsController.BASE_REQUEST_MAPPING)
public class ProductsController {

	protected static final String BASE_REQUEST_MAPPING = "/products";

	@Inject
	private ProductsService productsService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	private ResponseEntity<List<ProductDTO>> findAllProducts(@RequestParam final int page,
			@RequestParam final int pageSize, @Nullable @RequestParam final String search) {
		List<ProductDTO> filteredProducts = productsService.getProducts(page, pageSize, search);
		return new ResponseEntity<List<ProductDTO>>(filteredProducts, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<ProductDetailsDTO> findProductDetails(@PathVariable(value = "id") final Long id) {
		ProductDetailsDTO details = productsService.getProductDetails(id);
		return new ResponseEntity<ProductDetailsDTO>(details, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	private ResponseEntity<String> createProduct(@RequestBody final ProductDTO product) {
		productsService.insert(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteProduct(@PathVariable(value = "id") final Long id) {
		productsService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
