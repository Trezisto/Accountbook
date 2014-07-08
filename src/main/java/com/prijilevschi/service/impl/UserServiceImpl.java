package com.prijilevschi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prijilevschi.dao.UserDAO;
import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private	UserDAO userDao;
	
	@Transactional
	public Long save(User user) {
		return null;
		
	}

	@Transactional
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
}
