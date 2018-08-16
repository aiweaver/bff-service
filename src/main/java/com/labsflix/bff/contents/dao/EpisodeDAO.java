package com.labsflix.bff.contents.dao;

import java.util.Arrays;
import java.util.List;

import com.labsflix.bff.contents.vo.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("episodeDAO")
public class EpisodeDAO {

	@Value("${api.connect.path}")
	private String apic;
	
	@Value("${api.services.contents-service}")
	private String serviceUrl;

	private RestTemplate restTemplate;

	@Autowired
	public EpisodeDAO(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Season> getAllEpisodes(String content) {
        return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/contents/%s/episodes", serviceUrl, content), Season[].class));
    }
	
}
