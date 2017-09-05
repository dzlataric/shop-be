package com.shop.web.util;

import com.shop.web.dto.CategoryDTO;
import com.shop.web.dto.ProductDTO;
import com.shop.web.entity.Category;
import com.shop.web.entity.Product;

public class ObjectConversionUtil {

	public static CategoryDTO convertCategoryToDTO(final Category category) {
		return new CategoryDTO(category.getId(), category.getTitle(), category.getDescription());
	}

	public static Category convertDTOToCategory(final CategoryDTO categoryDTO) {
		return new Category().withTitle(categoryDTO.getTitle()).withDescription(categoryDTO.getDescription());
	}
	
	public static ProductDTO convertProductToDTO(final Product product) {
		return new ProductDTO(product.getId(), product.getName(), product.getStock(), product.getPrice(),
				product.getCategory().getTitle(), product.getCategory().getId(), product.getProductDetails().getId());
	}
	
}
