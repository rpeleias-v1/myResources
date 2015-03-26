package com.rodrigopeleias.myresources.model;

import java.io.Serializable;

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
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Role name = " + name; 
	}

}
