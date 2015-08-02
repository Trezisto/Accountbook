package com.prijilevschi.controller;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;

@ManagedBean(name = "userController")
@RequestScoped
public class UserController implements Serializable{
	private static final long serialVersionUID = -2417622386650583160L;

	private String value = "This editor is provided by PrimeFaces";

	@ManagedProperty(value = "#{userService}")
	private transient UserService userService;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
