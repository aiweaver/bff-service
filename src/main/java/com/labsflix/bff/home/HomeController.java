package com.labsflix.bff.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.labsflix.bff.domain.Account;
import com.labsflix.bff.profile.service.ProfileService;
import com.labsflix.bff.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@Value("${api.bff.path}")
	private String apiConnect;

	private ProfileService profileService;

	@Autowired
	public HomeController(ProfileService profileService) {
		this.profileService = profileService;
	}

	@GetMapping("/")
	public String root(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();

		if (session.getAttribute("username") != null) {
			session.removeAttribute("username");
			session.removeAttribute("profile");
		}
		return "login";
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
	
	@PostMapping("/login")
	public Model login(Account account, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String username = account.getUsername();
		session.setAttribute("username", username);
		
		List<Profile> profiles = profileService.getProfiles(username);
		
		String defaultProfile = profiles.get(0).getId();
		session.setAttribute("profile", defaultProfile);

		return model;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("profile");
		return "redirect:/login";
	}
	
	@GetMapping("/home")
	public String home(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			return "redirect:/index";
		}

		return "index-v3";
	}

	@GetMapping("/categories/{category}")
	public String category(HttpServletRequest request, @PathVariable(name="category") String category) {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			return "redirect:/index";
		}

		return "category";
	}

}
