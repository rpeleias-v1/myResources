package com.rodrigopeleias.myresources.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rodrigopeleias.myresources.model.User;
import com.rodrigopeleias.myresources.util.UserBuilder;

public class UserTest {
	
	private User user;
	
	@Before
	public void setUp() {
		user = new UserBuilder()				
				.withUsername("rpeleias")
				.withPassword("rpeleias123")
				.withEmail("rpeleias@hotmail.com")
				.build();
	}

	@Test
	public void testIsNewUser() {		
		assertTrue(user.isNew());		
	}
	
	@Test
	public void testIsUpdatedUser() {
		user.setId(1L);
		assertFalse(user.isNew());		
	}

}
