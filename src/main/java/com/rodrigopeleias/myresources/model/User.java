package com.rodrigopeleias.myresources.model;

import java.io.Serializable;
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
public class User implements Serializable{
	
	private static final long serialVersionUID = 125645446680664635L;

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
	
	public User() {	
	}
	
	public User(Long id, String username, String password, String email,
			Date dateCreation, List<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateCreation = dateCreation;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public boolean isNew() {
		return id == null ? true : false;
	}

	@Override
	public String toString() {
		return "id="+id+", username="+username;
	}
}
