package com.labsflix.bff.category.service;

import java.util.List;

import com.labsflix.bff.category.dao.CategoryDAO;
import com.labsflix.bff.category.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryService {

	private CategoryDAO categoryDAO;

	@Autowired
	public CategoryService(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public List<Category> getCategoryList () {
		return categoryDAO.getCategoryList();
	}
	
	public Category getCategory(String id) {
		return categoryDAO.getCategory(id);
	}
	
}
