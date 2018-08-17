package com.labsflix.bff.notification.controller;

import java.util.List;

import com.labsflix.bff.domain.Content;
import com.labsflix.bff.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class NotificationController {

	private NotificationService notificationService;

	@Autowired
	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@GetMapping("/notifications")
	public List<Content> getNotifications() {
		return notificationService.getNotifications();
	}
}
