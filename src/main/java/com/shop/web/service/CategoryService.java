package com.shop.web.service;

import com.shop.web.entity.Category;

public interface CategoryService {

	void insert(Category category);
	
	void delete(Long id);
	
}
