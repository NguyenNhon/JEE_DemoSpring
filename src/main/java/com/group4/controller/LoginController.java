package com.group4.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.group4.model.User;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, Model model) {
		if (user.getUsername().equals("meo") && user.getPassword().equals("123")) {
			user.setProfile("resources/images/meo.jpg");
			user.getFriends().add("mimi");
			user.getFriends().add("lyly");
		} else if (user.getUsername().equals("mimi") && user.getPassword().equals("123")) {
			user.setProfile("resources/images/mimi.jpg");
			user.getFriends().add("meo");
			user.getFriends().add("lyly");
		} else if (user.getUsername().equals("lyly") && user.getPassword().equals("123")) {
			user.setProfile("resources/images/lyly.jpg");
			user.getFriends().add("mimi");
			user.getFriends().add("meo");
		} else {
			return "login";
		}
		model.addAttribute("user", user);
		return "profile";
	}

	@RequestMapping(value = "/friend", method = RequestMethod.GET)
	public String login(@RequestParam String username, Model model) {
		User user = new User();
		user.setUsername(username);
		if (user.getUsername().equals("meo")) {
			user.setProfile("resources/images/meo.jpg");
			user.getFriends().add("mimi");
			user.getFriends().add("lyly");
		} else if (user.getUsername().equals("mimi")) {
			user.setProfile("resources/images/mimi.jpg");
			user.getFriends().add("meo");
			user.getFriends().add("lyly");
		} else if (user.getUsername().equals("lyly")) {
			user.setProfile("resources/images/lyly.jpg");
			user.getFriends().add("mimi");
			user.getFriends().add("meo");
		} else {
			return "profile";
		}
		model.addAttribute("user", user);
		return "friend";
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @PathVariable String username, Model model,
			@RequestParam("image") MultipartFile image) {
		try {
            Path path = Paths.get(request.getServletContext().getRealPath("") + "/resources/images/" + username + ".jpg");
            if (Files.exists(path)) {
            	image.transferTo(path.toFile());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/";
		}
		System.out.println("abc");
		User user = new User();
		user.setUsername(username);
		if (user.getUsername().equals("meo")) {
			user.setProfile("resources/images/meo.jpg");
			user.getFriends().add("mimi");
			user.getFriends().add("lyly");
			user.setPassword("123");
		} else if (user.getUsername().equals("mimi")) {
			user.setProfile("resources/images/mimi.jpg");
			user.getFriends().add("meo");
			user.getFriends().add("lyly");
			user.setPassword("123");
		} else if (user.getUsername().equals("lyly")) {
			user.setProfile("resources/images/lyly.jpg");
			user.getFriends().add("mimi");
			user.getFriends().add("meo");
			user.setPassword("123");
		} else {
			return "redirect:/";
		}
		model.addAttribute("user", user);
		return "profile";
	}
}
