package com.labsflix.bff.category.controller;

import java.util.List;

import com.labsflix.bff.category.service.CategoryService;
import com.labsflix.bff.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/categories")
	public List<Category> getCategories() {
		return categoryService.getCategoryList();
	}
	
	@GetMapping("/categories/{id}")
	public Category getCategory(@PathVariable(value = "id") String id) {
		return categoryService.getCategory(id);
	}

}
