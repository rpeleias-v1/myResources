package com.rodrigopeleias.myresources.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigopeleias.myresources.dao.RoleDAO;
import com.rodrigopeleias.myresources.dao.UserDAO;
import com.rodrigopeleias.myresources.model.Role;
import com.rodrigopeleias.myresources.model.User;
import com.rodrigopeleias.myresources.service.UserManagerService;

@Service
public class UserManagerServiceImpl implements UserManagerService{

	@Autowired(required=true)
	private UserDAO userDAO;
	
	@Autowired(required=true)
	private RoleDAO roleDAO;
	
	@Override
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);		
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);		
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return userDAO.listUsers();
	}

	@Override
	@Transactional
	public User getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);		
	}

	@Override
	@Transactional
	public User getUserByUsernameAndPassword(String username, String password) {
		return userDAO.getUserByUsernameAndPassword(username, password);
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		userDAO.removeUser(id);		
	}

	@Override
	@Transactional
	public void addRole(Role role) {
		roleDAO.addRole(role);		
	}

	@Override
	@Transactional
	public void updateRole(Role role) {
		roleDAO.updateRole(role);		
	}

	@Override
	@Transactional
	public Role getRoleByName(String rolename) {		
		return roleDAO.getRoleByName(rolename);
	}

	@Override
	@Transactional
	public void removeRole(int id) {
		roleDAO.removeRole(id);
	}

	@Override
	@Transactional
	public List<Role> listRoles() {
		return roleDAO.listRoles();
	}
}
