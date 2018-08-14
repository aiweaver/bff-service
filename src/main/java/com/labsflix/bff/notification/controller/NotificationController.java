package com.labsflix.bff.notification.controller;

import java.util.List;

import com.labsflix.bff.contents.vo.Content;
import com.labsflix.bff.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
 
	@RequestMapping(path="/notifications", method=RequestMethod.GET, name="getNotifications")
	public List<Content> getNotifications() {
		List<Content> notifications = notificationService.getNotifications();
		return notifications;
	}
}
