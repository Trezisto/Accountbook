package com.prijilevschi.dao.impl;

import javax.persistence.NoResultException;
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
	public User findByUsername(String username) {
		TypedQuery<User> query = entityManager.createQuery("FROM User WHERE username = :username", User.class);
		query.setParameter("username", username);
		try {
			return query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}
