package com.rodrigopeleias.myresources.util;

import java.util.Date;

import com.rodrigopeleias.myresources.model.Role;

public class RoleBuilder {
	
	private Long id;
	private String name;	
	
	public RoleBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public RoleBuilder withName(String name) {
		this.name = name;
		return this;
	}
		
	public Role build() {
		return new Role(id, name, new Date());
	}
}
