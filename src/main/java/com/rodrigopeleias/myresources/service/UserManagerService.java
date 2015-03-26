package com.rodrigopeleias.myresources.service;

import java.util.List;

import com.rodrigopeleias.myresources.model.Role;
import com.rodrigopeleias.myresources.model.User;

public interface UserManagerService {
	
	void addUser(User user);
	void updateUser(User user);
	List<User> listUsers();
	User getUserByUsername(String username);
	User getUserByUsernameAndPassword(String username, String password);
	void removeUser(int id);void addRole(Role role);
	void updateRole(Role role);
	Role getRoleByName(String rolename);
	void removeRole(int id);

}
