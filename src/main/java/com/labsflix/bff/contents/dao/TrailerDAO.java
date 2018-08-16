package com.labsflix.bff.contents.dao;

import java.util.Arrays;
import java.util.List;

import com.labsflix.bff.contents.vo.Trailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("trailerDAO")
public class TrailerDAO {

	@Value("${api.connect.path}")
	private String apic;
	
	@Value("${api.services.contents-service}")
	private String serviceUrl;

	private RestTemplate restTemplate;

	@Autowired
	public TrailerDAO(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Trailer> getTrailers(String content) {
        return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/contents/%s/trailers", serviceUrl, content), Trailer[].class));
    }
	
}
