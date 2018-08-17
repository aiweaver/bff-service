package com.labsflix.bff.profile.service;

import java.util.Arrays;
import java.util.List;

import com.labsflix.bff.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("profileService")
public class ProfileService {

	@Value("${api.services.account-service}")
	private String serviceUrl;

	private RestTemplate restTemplate;

	@Autowired
	public ProfileService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Profile> getProfiles(String username) {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/%s/profiles", serviceUrl, username), Profile[].class));
	}
	
}
