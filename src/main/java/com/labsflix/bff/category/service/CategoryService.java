package com.labsflix.bff.category.service;

import java.util.Arrays;
import java.util.List;

import com.labsflix.bff.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("categoryService")
public class CategoryService {

	@Value("${api.services.contents-service}")
	private String serviceUrl;

	private RestTemplate restTemplate;

	@Autowired
	public CategoryService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Category> getCategoryList() {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/categories", serviceUrl), Category[].class));
	}

	public Category getCategory(String id) {
		return restTemplate.getForObject(String.format("%s/v1/categories/%s", serviceUrl, id), Category.class);
	}
	
}
