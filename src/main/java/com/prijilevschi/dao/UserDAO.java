package com.prijilevschi.dao;

import com.prijilevschi.model.User;

public interface UserDAO extends BaseDAO<User>{
	User findByUsernameAndPassword(String username, String password);
}
