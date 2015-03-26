package com.rodrigopeleias.myresources.service;

import java.util.List;

import com.rodrigopeleias.myresources.model.Role;
import com.rodrigopeleias.myresources.model.User;

public interface UserManagerService {
	
	void addUser(User user);
	void updateUser(User user);
	List<User> listUsers();
	User getUserByUsername(String username);
	User getUserById(long id);
	User getUserByUsernameAndPassword(String username, String password);
	void removeUser(long id);void addRole(Role role);
	void updateRole(Role role);
	Role getRoleByName(String rolename);
	List<Role> listRoles();
	void removeRole(long id);

}
