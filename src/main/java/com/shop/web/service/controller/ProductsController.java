package com.shop.web.service.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.web.service.ProductsService;
import com.shop.web.service.dto.ProductDTO;

@RestController
@RequestMapping(value = ProductsController.BASE_REQUEST_MAPPING)
public class ProductsController {

	protected static final String BASE_REQUEST_MAPPING = "/products";

	@Inject
	private ProductsService productsService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	private ResponseEntity<ProductDTO> createProduct(@RequestBody final ProductDTO product) {
		return new ResponseEntity<ProductDTO>(productsService.insert(product), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	private ResponseEntity<ProductDTO> updateProduct(@PathVariable(value = "id") final Long id,
			@RequestBody final ProductDTO product) {
		return new ResponseEntity<ProductDTO>(productsService.update(id, product), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteProduct(@PathVariable(value = "id") final Long id) {
		productsService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
