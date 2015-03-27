package com.rodrigopeleias.myresources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rodrigopeleias.myresources.model.Role;
import com.rodrigopeleias.myresources.service.UserManagerService;

@Controller
public class RolesController {
	
	@Autowired(required=true)
	private UserManagerService userManagerService;

	@RequestMapping(value = "/cms/roles", method = RequestMethod.GET)
	public String rolesScreen(Model model) {
		Role role = new Role();
		model.addAttribute("role", role);
		model.addAttribute("rolesList", this.userManagerService.listRoles());
		return "cms/roles";
	}
	
	@RequestMapping(value = "/cms/roles/add", method = RequestMethod.POST)
	public String addRole(@ModelAttribute("role") Role role) {
		return "redirect:/cms/roles";
	}
}
