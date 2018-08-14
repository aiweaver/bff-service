package com.labsflix.bff.category.dao;

import java.util.Arrays;
import java.util.List;

import com.labsflix.bff.category.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("categoryDAO")
public class CategoryDAO {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.connect.path}")
	private String apic;
	
	@Value("${api.services.contents-service}")
	private String serviceUrl;
	
	public List<Category> getCategoryList() {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/categories", serviceUrl), Category[].class));
    }
	
	public Category getCategory(String id) {
		return restTemplate.getForObject(String.format("%s/v1/categories/%s", serviceUrl, id), Category.class);
    }
	
}