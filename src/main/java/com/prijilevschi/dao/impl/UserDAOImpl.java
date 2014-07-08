package com.prijilevschi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.prijilevschi.dao.UserDAO;
import com.prijilevschi.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public Long persist(User user) {
		entityManager.persist(user);
		entityManager.flush();
		return user.getId();
	}

	public Long merge(User user) {
		entityManager.merge(user);
		entityManager.flush();
		return user.getId();
	}

	public User findById(Long id) {
		return entityManager.find(User.class, id);
	}

	public List<User> findAll() {
		CriteriaQuery<User> cq = entityManager.getCriteriaBuilder().createQuery(User.class);
		cq.select(cq.from(User.class));
		return entityManager.createQuery(cq).getResultList();
	}

	public void remove(User user) {
		entityManager.remove(user);		
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
