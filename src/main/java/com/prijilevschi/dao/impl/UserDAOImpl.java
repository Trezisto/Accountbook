package com.prijilevschi.dao.impl;

import org.springframework.stereotype.Repository;

import com.prijilevschi.dao.UserDAO;
import com.prijilevschi.model.User;

@Repository("userDao")
public class UserDAOImpl extends AbstractBaseDAO<User> implements UserDAO {
    public UserDAOImpl() {
        super(User.class);
    }
}
