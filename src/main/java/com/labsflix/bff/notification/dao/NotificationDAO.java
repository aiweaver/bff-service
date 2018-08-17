package com.labsflix.bff.notification.dao;

import java.util.Arrays;
import java.util.List;

import com.labsflix.bff.contents.vo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("notificationDAO")
public class NotificationDAO {

	private RestTemplate restTemplate;

	@Autowired
	public NotificationDAO(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Value("${api.services.recommendation-service}")
	private String serviceUrl;
	
	public List<Content> getNotifications() {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/notifications", serviceUrl), Content[].class));
    }
	
}