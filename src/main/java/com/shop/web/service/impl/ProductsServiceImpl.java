package com.shop.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.shop.web.dto.ProductDTO;
import com.shop.web.repository.ProductRepository;
import com.shop.web.service.ProductsService;
import com.shop.web.util.ObjectConversionUtil;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Inject
	private ProductRepository productRepository;

	@Override
	public List<ProductDTO> getProducts(final int page, final int pageSize, final String search) {
		return productRepository.findAll().stream().skip((page - 1) * pageSize).limit(pageSize)
				.filter(product -> StringUtils.containsIgnoreCase(product.getName(), search))
				.map(product -> ObjectConversionUtil.convertProductToDTO(product)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public ProductDTO insert(ProductDTO productDTO) {
		return null;
	}

	@Override
	@Transactional
	public ProductDTO update(Long id, ProductDTO productDTO) {
		return null;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productRepository.delete(id);
	}

}
