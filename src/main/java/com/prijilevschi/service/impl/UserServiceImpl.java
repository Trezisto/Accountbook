package com.prijilevschi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prijilevschi.dao.UserDAO;
import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private	UserDAO userDao;
	
	@Transactional
	public Long save(User user) {
		Long id;
		if(user.getId() == null){
			id = userDao.persist(user);
		}
		else {
			User temp = userDao.merge(user);
			id = temp.getId();
		}
		return id;
	}

	@Transactional
	public void delete(User user) {
		userDao.remove(user);
		
	}

	@Transactional(readOnly = true)
	public User getById(Long id) {
		return userDao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<User> getAll() {
		return userDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean login(String username, String password) {
		return userDao.findByUsernameAndPassword(username, password) != null;
	}
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
}
