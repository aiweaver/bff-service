package com.labsflix.bff.notification.service;

import java.util.Arrays;
import java.util.List;

import com.labsflix.bff.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("notificationService")
public class NotificationService {

	@Value("${api.services.recommendation-service}")
	private String serviceUrl;

	private RestTemplate restTemplate;

	@Autowired
	public NotificationService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Content> getNotifications() {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/notifications", serviceUrl), Content[].class));
	}
}
