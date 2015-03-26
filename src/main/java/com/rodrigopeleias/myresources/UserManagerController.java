package com.rodrigopeleias.myresources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rodrigopeleias.myresources.service.UserManagerService;

@Controller
public class UserManagerController {

	@Autowired
	private UserManagerService userManagerService;
	
	@RequestMapping("/cms/users")
	public String userHomeScreen(Model model) {
		model.addAttribute("userList", userManagerService.listUsers());
		model.addAttribute("rolesList", userManagerService.listRoles());
		return "userHomeScreen";
	}
}
