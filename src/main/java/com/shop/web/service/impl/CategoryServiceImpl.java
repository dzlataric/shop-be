package com.shop.web.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shop.web.entity.Category;
import com.shop.web.repository.CategoryRepository;
import com.shop.web.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Inject
	private CategoryRepository categoryRepository;
	
	@Override
	public void insert(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void delete(Long id) {
		categoryRepository.delete(id);
	}

}
