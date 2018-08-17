package com.labsflix.bff.notification.service;

import java.util.List;

import com.labsflix.bff.contents.vo.Content;
import com.labsflix.bff.notification.dao.NotificationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("notificationService")
public class NotificationService {
	
	@Autowired
	private NotificationDAO notificationDAO;
 
	public List<Content> getNotifications() {
		return notificationDAO.getNotifications();
	}
}
