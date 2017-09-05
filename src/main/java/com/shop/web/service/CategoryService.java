package com.shop.web.service;

import java.util.List;

import com.shop.web.dto.CategoryDTO;

public interface CategoryService {

	List<CategoryDTO> getCategories(int page, int pageSize, String search);
	
	CategoryDTO insert(CategoryDTO categoryDTO);
	
	void delete(Long id);
	
}
