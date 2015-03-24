package com.rodrigopeleias.myresources.dao;

import java.util.List;

import com.rodrigopeleias.myresources.model.User;

public interface UserService {
	
	void addUser(User user);
	void updateUser(User user);
	List<User> listUsers();
	User getUserByUsername(String username);
	void removeUser(int id);

}
