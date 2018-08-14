package com.labsflix.bff.category.service;

import java.util.List;

import com.labsflix.bff.category.dao.CategoryDAO;
import com.labsflix.bff.category.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;

	public List<Category> getCategoryList () {
		List<Category> categories = categoryDAO.getCategoryList();
		return categories;
	}
	
	public Category getCategory(String id) {
		Category category = categoryDAO.getCategory(id);
		return category;
	}
	
}
