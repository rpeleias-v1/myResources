package com.rodrigopeleias.myresources.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rodrigopeleias.myresources.dao.UserDAO;
import com.rodrigopeleias.myresources.model.Role;
import com.rodrigopeleias.myresources.model.User;

public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDao;
	
	private static final String rolePrefix = "ROLE_";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username + " not found"); 
		}
		return getUserDetails(user);
	}

	private UserDetails getUserDetails(final User user) {
		return new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				return true;
			}
			
			@Override
			public String getUsername() {
				return user.getUsername();
			}
			
			@Override
			public String getPassword() {
				return user.getPassword();
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
				for (Role role : user.getRoles()) {
					auths.add(new SimpleGrantedAuthority(rolePrefix + role.getName().toUpperCase()));
				}                
                return auths;
			}
		};
	}

}
