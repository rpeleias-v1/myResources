package com.rodrigopeleias.myresources.dao;

import com.rodrigopeleias.myresources.model.Role;

public interface RoleDAO {
	
	void addRole(Role role);
	void updateRole(Role role);
	Role getRoleByName(String rolename);
	void removeRole(int id);

}
