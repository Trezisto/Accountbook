package com.prijilevschi.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import com.prijilevschi.model.User;

public interface UserService {
	Long save(User user) throws InvalidKeySpecException, NoSuchAlgorithmException;
	void delete(User user);
	User getById(Long id);
	List<User> getAll();
	boolean login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
