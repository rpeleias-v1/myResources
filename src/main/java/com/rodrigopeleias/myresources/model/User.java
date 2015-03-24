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
@Table(name="USER")
public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Date dateCreation;
	
	
	
	@Override
	public String toString() {
		return "id="+id+", username="+username;
	}

}
