package com.labsflix.bff.contents.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.labsflix.bff.domain.Content;
import com.labsflix.bff.domain.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("contentsService")
public class ContentsService {

	@Value("${api.services.contents-service}")
	private String serviceUrl;

	private RestTemplate restTemplate;

	@Autowired
	public ContentsService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Content> getContentsByCategory(String category) {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/contents?category=%s", serviceUrl, category), Content[].class));
	}

	public List<Content> getContentsByTitle(String title) {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/contents/search?title=%s", serviceUrl, title), Content[].class));
	}

	public Content getContentsDetail(String id) {
		return restTemplate.getForObject(String.format("%s/v1/contents/%s", serviceUrl, id), Content.class);
	}

	public List<Season> getAllEpisodes(String content) {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/contents/%s/episodes", serviceUrl, content), Season[].class));
	}

	public List<Content> getSmiliars(String id, String category) {
		Content content = this.getContentsDetail(id);
		List<Content> similars = new ArrayList<>(getContentsByCategory(category));
		similars.remove(content);
		return similars;
	}

}
