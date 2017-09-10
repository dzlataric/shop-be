package com.shop.web.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.shop.web.dto.CategoryDTO;

public interface CategoryService {

	@PreAuthorize("hasAuthority('ROLE_USER')")
	List<CategoryDTO> getCategories(int page, int pageSize, String search);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	CategoryDTO insert(CategoryDTO categoryDTO);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	void delete(Long id);
	
}
