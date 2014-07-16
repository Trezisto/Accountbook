package com.prijilevschi.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;

@ManagedBean(name = "userController")
@RequestScoped
public class UserController implements Serializable{
	private static final long serialVersionUID = -2417622386650583160L;

	private String value = "This editor is provided by PrimeFaces";
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService; 
	 
	public String createUser() {
//		User user = new User();
//		user.setUserName("test");
//		user.setPassword("test");
//		
//		Long id = userService.save(user); //constraint violation
		return userService.getById(1L).getUserName();
	}
	
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
