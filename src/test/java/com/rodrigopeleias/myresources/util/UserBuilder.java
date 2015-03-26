package com.rodrigopeleias.myresources.util;

import java.util.Date;
import java.util.List;

import com.rodrigopeleias.myresources.model.Role;
import com.rodrigopeleias.myresources.model.User;

public class UserBuilder {
	
	private Long id;
	private String username;
	private String password;
	private String email;
	private List<Role> roles;
	
	public UserBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public UserBuilder withUsername(String username) {
		this.username = username;
		return this;
	}
	
	public UserBuilder withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public UserBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public UserBuilder withRoles(List<Role> roles) {
		this.roles = roles;
		return this;
	}
	
	public User build() {
		return new User(id, username, password, email, new Date(), roles);
	}	

}
