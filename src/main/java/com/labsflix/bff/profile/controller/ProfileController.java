package com.labsflix.bff.profile.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.labsflix.bff.profile.service.ProfileService;
import com.labsflix.bff.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
 
	@RequestMapping(path="/profiles", method=RequestMethod.GET, name="getProfiles")
	public List<Profile> getProfiles(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();

		System.out.println("=====> " + username);

		List<Profile> profiles = profileService.getProfiles(username);
		return profiles;
	}
}
