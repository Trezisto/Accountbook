package com.prijilevschi.dao;

import com.prijilevschi.model.User;

public interface UserDAO extends BaseDAO<User>{
	User findByUsername(String username);
}
