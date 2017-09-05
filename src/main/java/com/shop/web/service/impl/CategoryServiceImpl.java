package com.shop.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.shop.web.dto.CategoryDTO;
import com.shop.web.entity.Category;
import com.shop.web.repository.CategoryRepository;
import com.shop.web.service.CategoryService;
import com.shop.web.util.ObjectConversionUtil;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryDTO> getCategories(final int page, final int pageSize, final String search) {
		return categoryRepository.findAll().stream().skip((page - 1) * pageSize).limit(pageSize)
				.filter(category -> StringUtils.containsIgnoreCase(category.getTitle(), search))
				.map(category -> ObjectConversionUtil.convertCategoryToDTO(category))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDTO insert(CategoryDTO categoryDTO) {
		Category saved = categoryRepository.save(ObjectConversionUtil.convertDTOToCategory(categoryDTO));
		return new CategoryDTO(saved.getId(), saved.getTitle(), saved.getDescription());
	}

	@Override
	public void delete(Long id) {
		categoryRepository.delete(id);
	}

}
