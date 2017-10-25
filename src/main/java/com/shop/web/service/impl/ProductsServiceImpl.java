package com.shop.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.shop.web.dto.ProductDTO;
import com.shop.web.dto.ProductDetailsDTO;
import com.shop.web.entity.Product;
import com.shop.web.entity.ProductDetails;
import com.shop.web.repository.CategoryRepository;
import com.shop.web.repository.ProductDetailsRepository;
import com.shop.web.repository.ProductRepository;
import com.shop.web.service.ProductsService;
import com.shop.web.util.ObjectConversionUtil;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Inject
	private ProductRepository productRepository;
	@Inject
	private ProductDetailsRepository productDetailsRepository;
	@Inject
	private CategoryRepository categoryRepository;

	@Override
	public List<ProductDTO> getProducts(final int page, final int pageSize, final String search) {
		return productRepository.findAll()
				.stream().skip((page - 1) * pageSize)
				.limit(pageSize)
				.filter(product -> StringUtils.containsIgnoreCase(product.getName(), search))
				.map(product -> ObjectConversionUtil.convertProductToDTO(product)).collect(Collectors.toList());
	}

	@Override
	public ProductDetailsDTO getProductDetails(Long productId) {
		Product product = productRepository.findOne(productId);
		ProductDetails details = productDetailsRepository.findByProductId(productId);
		return new ProductDetailsDTO(
				details.getId(), product.getName(),
				product.getStock(), product.getPrice(),
				product.getCategory().getTitle(),
				details.getCountryOfOrigin(),
				details.getManufacturer(),
				details.getProductionYear(),
				new SimpleDateFormat("EEE, dd MMM, yyyy").format(details.getExpiryDate()), details.getImageUrl());
	}

	@Override
	@Transactional
	public void insert(ProductDTO productDTO) {
		ProductDetails details = new ProductDetails()
				.withCountryOfOrigin(productDTO.getCountry())
				.withManufacturer(productDTO.getManufacturer())
				.withProductionYear(productDTO.getProductionYear())
				.withExpiryDate(new Date(2017,1,1))
				.withImageUrl("http://imalures.com/wp-content/uploads/2015/01/127880648.jpg");
		Product product = new Product()
				.withCategory(categoryRepository.findOne(productDTO.getCategoryId()))
				.withName(productDTO.getName())
				.withPrice(productDTO.getPrice())
				.withStock(productDTO.getStock())
				.withProductDetails(details);
		productRepository.save(product);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productRepository.delete(id);
	}
}
