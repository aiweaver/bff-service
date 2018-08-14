package com.labsflix.bff.profile.service;

import java.util.List;

import com.labsflix.bff.profile.dao.ProfileDAO;
import com.labsflix.bff.profile.vo.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("profileService")
public class ProfileService {
	
	@Autowired
	private ProfileDAO profileDAO;
	
	public List<Profile> getProfiles(String username) {
		List<Profile> profiles = profileDAO.getProfiles(username);
		return profiles;
	}
	
}
