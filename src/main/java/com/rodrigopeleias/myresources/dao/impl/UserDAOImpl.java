package com.rodrigopeleias.myresources.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigopeleias.myresources.dao.UserDAO;
import com.rodrigopeleias.myresources.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
		
	@Autowired
	private SessionFactory sessionFactory;
		
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User user) {
		getSession().persist(user);		
	}
	
	@Override
	public void updateUser(User user) {		
		getSession().update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {		
		List<User> users = getSession().createQuery("from User").list();		
		return users;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public User getUserByUsername(String username) {
		Query query = getSession().createQuery("from User u join fetch u.roles where username = :username");
		query.setString("username", username);
		User user = (User)query.uniqueResult();
		return user;
	}
	

	@Override
	public void removeUser(int id) {
		User user = (User)getSession().load(User.class, new Integer(id));
		if (user != null) {
			getSession().delete(user);
		}
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		Query query = getSession().createQuery("from User where username = :username and password = :password");
		query.setString("username", username);
		query.setString("password", password);
		User user = (User)query.uniqueResult();
		return user;
	}
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
