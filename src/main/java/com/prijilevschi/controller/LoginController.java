package com.prijilevschi.controller;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;

@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController implements Serializable{
	private static final long serialVersionUID = 3285542075160514743L;
	
	private String username;
	private String password;
	
	@ManagedProperty(value = "#{userService}")
	private transient UserService userService;
	
	public String performLogin(){
		try{
//			User user = new User();
//			user.setUserName("test");
//			user.setPassword("test");
//
//			Long id = userService.save(user); //constraint violation
			boolean result = userService.login(username, password);

			if(result){
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				session.setAttribute("username", username);

				return "index";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login", "Please Try Again!"));

				return "login";
			}
		} catch(NoSuchAlgorithmException | InvalidKeySpecException e){ 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exception Occured", e.getMessage()));

			return "login";
		}
	}
	
	public String logout(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "login";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
