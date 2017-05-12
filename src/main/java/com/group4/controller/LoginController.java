package com.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group4.model.User;

@Controller
public class LoginController {
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user, Model model) {
		if (!user.getUsername().equals("admin") || !user.getPassword().equals("123")) {
			return "login";
		}
		return "redirect:/" + user.getUsername();
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String getProfile(User user, Model model) {
		return "profile";
	}
}
