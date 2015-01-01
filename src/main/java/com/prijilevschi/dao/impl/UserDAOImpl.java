package com.prijilevschi.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.prijilevschi.dao.UserDAO;
import com.prijilevschi.model.User;

@Repository("userDao")
public class UserDAOImpl extends AbstractBaseDAO<User> implements UserDAO {
    public UserDAOImpl() {
        super(User.class);
    }

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		TypedQuery<User> query = entityManager.createQuery("FROM User WHERE username = :username AND password = :password", User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		return query.getSingleResult();
	}
}
