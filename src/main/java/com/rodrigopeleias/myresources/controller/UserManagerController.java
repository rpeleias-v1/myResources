package com.rodrigopeleias.myresources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rodrigopeleias.myresources.model.User;
import com.rodrigopeleias.myresources.service.UserManagerService;

@Controller
public class UserManagerController {

	@Autowired(required=true)
	private UserManagerService userManagerService;
	
	private static final String USER_HOME_SCREEN = "cms/userHomeScreen";
	
	private static final String USER_HOME_REDIRECTION = "redirect:/cms/users";
		
	@RequestMapping(value = "/cms/users", method = RequestMethod.GET)
	public String userHomeScreen(Model model) {
		model.addAttribute("userResource", new User());
		addUserDetailsToScreen(model);
		return USER_HOME_SCREEN;
	}
	
	@RequestMapping(value = "/cms/users/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("userResource") User user) {
		if (user.isNew()) {
			this.userManagerService.addUser(user);
		} else {
			this.userManagerService.updateUser(user);
		}		
		return USER_HOME_REDIRECTION;
	}
	
	@RequestMapping("/cms/users/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {
		this.userManagerService.removeUser(id);
		return USER_HOME_REDIRECTION;
	}
	
	@RequestMapping("/cms/users/edit/{id}")
	public String editUser(@PathVariable("id") long id, Model model) {
		User user = this.userManagerService.getUserById(id);
		model.addAttribute("userResource", user);
		addUserDetailsToScreen(model);
		return USER_HOME_SCREEN;
	}

	private void addUserDetailsToScreen(Model model) {
		model.addAttribute("usersList", userManagerService.listUsers());
		model.addAttribute("rolesList", userManagerService.listRoles());
	}
}
