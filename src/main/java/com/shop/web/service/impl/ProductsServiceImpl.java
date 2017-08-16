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
						product.getCountryOfOrigin(), product.getManufacturer(), product.getPrice(),
						product.getProductionYear(), product.getExpiryDate(), product.getCategory().getId(),
						product.getReviews().stream().map(review -> review.getId()).collect(Collectors.toSet())))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public ProductDTO insert(ProductDTO productDTO) {
		Product product = new Product().withName(productDTO.getName()).withStock(productDTO.getStock())
				.withCategory(categoryRepository.findOne(productDTO.getCategoryId()))
				.withCountryOfOrigin(productDTO.getCountryOfOrigin()).withManufacturer(productDTO.getManufacturer())
				.withPrice(productDTO.getPrice()).withProductionYear(productDTO.getProductionYear())
				.withExpiryDate(productDTO.getExpiryDate());
		Product saved = productRepository.save(product);
		return new ProductDTO(saved.getId(), saved.getName(), saved.getStock(), saved.getCountryOfOrigin(),
				saved.getManufacturer(), saved.getPrice(), saved.getProductionYear(), saved.getExpiryDate(),
				saved.getCategory().getId(),
				saved.getReviews().stream().map(review -> review.getId()).collect(Collectors.toSet()));
	}

	@Override
	@Transactional
	public ProductDTO update(Long id, ProductDTO productDTO) {
		Product toUpdate = productRepository.findOne(id);
		if (toUpdate == null) {
			throw new EntityNotFoundException("Product not found!");
		}
		Product updated = productRepository.save(toUpdate.withId(id).withName(productDTO.getName()).withStock(productDTO.getStock())
				.withCategory(categoryRepository.findOne(productDTO.getCategoryId()))
				.withCountryOfOrigin(productDTO.getCountryOfOrigin()).withManufacturer(productDTO.getManufacturer())
				.withPrice(productDTO.getPrice()).withProductionYear(productDTO.getProductionYear())
				.withExpiryDate(productDTO.getExpiryDate()));

		return new ProductDTO(updated.getId(), updated.getName(), updated.getStock(), updated.getCountryOfOrigin(),
				updated.getManufacturer(), updated.getPrice(), updated.getProductionYear(), updated.getExpiryDate(),
				updated.getCategory().getId(),
				updated.getReviews().stream().map(review -> review.getId()).collect(Collectors.toSet()));
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productRepository.delete(id);
	}

}
