package com.shop.web.service;

import java.util.List;

import com.shop.web.service.dto.CategoryDTO;

public interface CategoryService {

	List<CategoryDTO> getCategories();
	
	CategoryDTO insert(CategoryDTO categoryDTO);
	
	void delete(Long id);
	
}
