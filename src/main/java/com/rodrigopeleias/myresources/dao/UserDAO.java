package com.rodrigopeleias.myresources.dao;

import java.util.List;

import com.rodrigopeleias.myresources.model.User;

public interface UserDAO {
	
	void addUser(User user);
	void updateUser(User user);
	List<User> listUsers();
	User getUserByUsername(String username);
	User getUserById(long id);
	User getUserByUsernameAndPassword(String username, String password);
	void removeUser(long id);

}
