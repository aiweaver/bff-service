package com.labsflix.bff.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.labsflix.bff.account.vo.Account;
import com.labsflix.bff.profile.service.ProfileService;
import com.labsflix.bff.profile.vo.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Value("${api.bff.path}")
	private String apiConnect;

	private ProfileService profileService;

	@Autowired
	public HomeController(ProfileService profileService) {
		this.profileService = profileService;
	}

	@GetMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("username") != null) {
			session.removeAttribute("username");
			session.removeAttribute("profile");			
		}

		model.addAttribute("apiconnect", apiConnect);
		return "login";
	}
	
	@GetMapping("/login")
	public Model login(Account account, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String username = account.getUsername();
		session.setAttribute("username", username);
		
		List<Profile> profiles = profileService.getProfiles(username);
		
		String defaultProfile = profiles.get(0).getId();
		session.setAttribute("profile", defaultProfile);
		logger.info("===== login profile: " + defaultProfile);

		return model;
	}
	
//	@GetMapping("/logout")
//	public String logout(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.removeAttribute("username");
//		session.removeAttribute("profile");
//		return "redirect:/login";
//	}
	
	@GetMapping("/home")
	public String home(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			return "redirect:/index";
		}

		// Account, Personalization 호출
		List<Profile> profiles = profileService.getProfiles("lpeterson2a@google.co.uk");

		String username = (String) session.getAttribute("username");
		if("lpeterson2a@google.co.uk".equals(username)){
			return "index";
		}else if("rbrooks29@si.edu".equals(username)){
			return "index2";
		}

		return "index";
	}

	@GetMapping("/categories/{category}")
	public String category(HttpServletRequest request, @PathVariable(name="category") String category) {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			return "redirect:/index";
		}

		logger.info("===== move category: " + category);
		return "category";
	}

	@GetMapping("/favorites")
	public String favorites(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			return "redirect:/index";
		}
		return "category";
	}
	
}
