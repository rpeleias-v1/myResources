package com.rodrigopeleias.myresources.dao;

import java.util.List;

import com.rodrigopeleias.myresources.model.Role;

public interface RoleDAO {
	
	void addRole(Role role);
	void updateRole(Role role);
	Role getRoleByName(String rolename);
	List<Role> listRoles();
	void removeRole(int id);

}
