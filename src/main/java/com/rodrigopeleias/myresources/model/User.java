package com.rodrigopeleias.myresources.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_RESOURCE")
public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Date dateCreation;
	
	@OneToMany
	private List<Role> roles;
		
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
		
	public List<Role> getRoles() {
		return roles;
	}

	@Override
	public String toString() {
		return "id="+id+", username="+username;
	}

}
