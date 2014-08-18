package com.prijilevschi.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;

@ManagedBean(name = "adminController")
@RequestScoped
public class AdminController implements Serializable{
	private static final long serialVersionUID = -8177403906895380735L;

	@ManagedProperty(value = "#{userService}")
	private UserService userService; 
	 
	private List<User> users;
	
	@PostConstruct
	public void init(){
		users = userService.getAll();
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
