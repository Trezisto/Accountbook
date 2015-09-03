package com.prijilevschi.controller;

import java.io.Serializable;
import java.net.ConnectException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.CannotCreateTransactionException;

import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;

@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController implements Serializable {
	private static final long serialVersionUID = 3285542075160514743L;

	private String username;
	private String password;

	@ManagedProperty(value = "#{userService}")
	private transient UserService userService;

	public String performLogin() {
		try {
			boolean result = userService.login(username, password);

			if (result) {
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				session.setAttribute("username", username);

				return "index";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login", "Please Try Again!"));
				
				return "login";
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exception Occured", e.getMessage()));
		} catch (CannotCreateTransactionException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Could not create connection to database server!", e.getMessage()));
		}
		return "login";

	}
	
	//TODO: make message wrong "userName" or "password"
	//TODO: add email field
	//TODO: Add password validation
	//TODO: Make composite component
	public String registerUser(){
		try {
			boolean usernameNotUsed = !userService.checkUserExists(username);

			if (usernameNotUsed) {
				User user = new User();
				user.setUserName(username);
				user.setPassword(password);
				userService.save(user);
				
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				session.setAttribute("username", username);

				return "index";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "User with such name already exists!", "Please Try Again!"));
				
				return "login";
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exception Occured", e.getMessage()));
		} catch (CannotCreateTransactionException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Could not create connection to database server!", e.getMessage()));
		}
		return "login";
	}

	public String logout() {
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
