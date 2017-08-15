package com.shop.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shop.web.entity.Product;
import com.shop.web.repository.CategoryRepository;
import com.shop.web.repository.ProductRepository;
import com.shop.web.service.ProductsService;
import com.shop.web.service.dto.ProductDTO;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Inject
	private ProductRepository productRepository;
	@Inject
	private CategoryRepository categoryRepository;

	@Override
	public List<ProductDTO> getProducts() {
		return productRepository.findAll().stream()
				.map(product -> new ProductDTO(product.getId(), product.getName(), product.getStock(),
						product.getProductDetails(), product.getCategory().getId(),
						product.getReviews().stream().map(review -> review.getId()).collect(Collectors.toSet())))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public ProductDTO insert(ProductDTO productDTO) {
		Product product = new Product().withName(productDTO.getName()).withStock(productDTO.getStock())
				.withCategory(categoryRepository.findOne(productDTO.getCategoryId()))
				.withProductDetails(productDTO.getDetails());
		Product result = productRepository.save(product);
		return new ProductDTO(result.getId(), result.getName(), result.getStock(), result.getProductDetails(),
				result.getCategory().getId(),
				result.getReviews().stream().map(review -> review.getId()).collect(Collectors.toSet()));
	}

	@Override
	@Transactional
	public ProductDTO update(Long id, ProductDTO productDTO) {
		Product toUpdate = productRepository.findOne(id);
		if (toUpdate == null) {
			throw new EntityNotFoundException("Product not found!");
		}
		Product result = productRepository.save(toUpdate.withName(productDTO.getName()).withStock(productDTO.getStock())
				.withCategory(categoryRepository.findOne(productDTO.getCategoryId()))
				.withProductDetails(productDTO.getDetails()));

		return new ProductDTO(result.getId(), result.getName(), result.getStock(), result.getProductDetails(),
				result.getCategory().getId(),
				result.getReviews().stream().map(review -> review.getId()).collect(Collectors.toSet()));
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productRepository.delete(id);
	}

}
