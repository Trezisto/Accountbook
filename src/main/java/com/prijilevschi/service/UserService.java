package com.prijilevschi.service;

import java.util.List;

import com.prijilevschi.model.User;

public interface UserService {
	Long save(User user);
	void delete(User user);
	User getById(Long id);
	List<User> getAll();
}
