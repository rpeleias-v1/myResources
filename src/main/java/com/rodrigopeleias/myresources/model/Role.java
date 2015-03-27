package com.rodrigopeleias.myresources.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role implements Serializable{
	
	private static final long serialVersionUID = -75219604739608637L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Date dateCreated;
	
	public Role() {	
	}

	public Role(Long id, String name, Date dateCreated) {
		super();
		this.id = id;
		this.name = name;
		this.dateCreated = dateCreated;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role name = " + name; 
	}

	public boolean isNew() {
		return id == null ? true : false;
	}

}
