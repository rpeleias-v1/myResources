package com.rodrigopeleias.myresources.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rodrigopeleias.myresources.util.RoleBuilder;

public class RoleTest {
	
	private Role role;
	
	@Before
	public void setUp() {
		role = new RoleBuilder()					
					.withName("admin")
					.build();
	}

	@Test
	public void testRoleIsNew() {
		assertTrue(role.isNew());		
	}

}
