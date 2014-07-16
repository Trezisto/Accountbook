package com.prijilevschi.dao;

import java.util.List;

import com.prijilevschi.model.User;

public interface UserDAO {
	Long persist(User user);
	User merge(User user);
	User findById(Long id);
	List<User> findAll();
	void remove(User user);
}
