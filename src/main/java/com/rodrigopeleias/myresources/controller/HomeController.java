package com.rodrigopeleias.myresources.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, Model model) {
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "logout";
	}
	
	@RequestMapping(value="/denied")
	public String denied() {
		return "denied";
	}
	
}
