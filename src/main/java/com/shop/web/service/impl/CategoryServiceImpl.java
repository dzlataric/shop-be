package com.shop.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shop.web.entity.Category;
import com.shop.web.repository.CategoryRepository;
import com.shop.web.service.CategoryService;
import com.shop.web.service.dto.CategoryDTO;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryDTO> getCategories() {
		return categoryRepository.findAll().stream()
				.map(category -> new CategoryDTO(category.getId(), category.getTitle(), category.getDescription()))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDTO insert(CategoryDTO categoryDTO) {
		Category category = new Category().withTitle(categoryDTO.getTitle())
				.withDescription(categoryDTO.getDescription());
		Category saved = categoryRepository.save(category);
		return new CategoryDTO(saved.getId(), saved.getTitle(), saved.getDescription());
	}

	@Override
	public void delete(Long id) {
		categoryRepository.delete(id);
	}

}
