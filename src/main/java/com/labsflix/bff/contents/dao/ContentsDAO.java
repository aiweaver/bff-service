package com.labsflix.bff.contents.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.labsflix.bff.contents.vo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("contentsDAO")
public class ContentsDAO {

	@Value("${api.connect.path}")
	private String apic;

	@Value("${api.services.contents-service}")
	private String serviceUrl;

	private RestTemplate restTemplate;

	@Autowired
	public ContentsDAO(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Content> getContentsByCategory(String category) {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/contents?category=%s", serviceUrl, category), Content[].class));
    }
	
	public List<Content> getContentsByTitle(String title) {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/contents/search?title=%s", serviceUrl, title), Content[].class));
    }
	
	public List<Content> getContentsByTitleFallBack(String title) {
		return new ArrayList<Content>();
	}

	public Content getContentsDetail(String id) {
        return restTemplate.getForObject(String.format("%s/v1/contents/%s", serviceUrl, id), Content.class);
    }
	
}
