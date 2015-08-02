package com.prijilevschi.service.impl;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prijilevschi.dao.UserDAO;
import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;
import com.prijilevschi.utils.HashPBKDF2Util;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private	UserDAO userDao;
	
	@Transactional
	public Long save(User user) throws InvalidKeySpecException, NoSuchAlgorithmException{
		Long id;

		String pass = user.getPassword(); 
		if(pass != null){
			user.setPassword(HashPBKDF2Util.generateStorngPasswordHash(pass));
		}

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
	public boolean login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		User user = userDao.findByUsername(username);
		return HashPBKDF2Util.validatePassword(password, user.getPassword());
	}
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	
	
}
