package com.shop.web.controller;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.web.dto.CategoryDTO;
import com.shop.web.service.CategoryService;

@RestController
@RequestMapping(value = CategoriesController.BASE_REQUEST_MAPPING)
public class CategoriesController {

	protected static final String BASE_REQUEST_MAPPING = "/categories";

	@Inject
	private CategoryService categoryService;

	
	@RequestMapping(value = "", method = RequestMethod.GET)
	private ResponseEntity<List<CategoryDTO>> findAllCategories(@RequestParam final int page,
			@RequestParam final int pageSize, @Nullable @RequestParam final String search) {
		return new ResponseEntity<List<CategoryDTO>>(categoryService.getCategories(page, pageSize, search), HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	private ResponseEntity<CategoryDTO> createCategory(@RequestBody final CategoryDTO category) {
		return new ResponseEntity<CategoryDTO>(categoryService.insert(category), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteCategory(@PathVariable(value = "id") final Long id) {
		categoryService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
