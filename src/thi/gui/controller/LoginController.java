package thi.gui.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import thi.common.iservices.IBenutzerkontoService;

@Named
@RequestScoped
public class LoginController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	
	@Inject
	private IBenutzerkontoService benutzerkontoService;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Navigation Case, described in faces-config.xml
	 */
	public String onLogin() {
		
		if( hasInputError() ) {
			return "";
		}
			
		if( benutzerkontoService.login( email, password) == false ) {
			return "ERROR";
		}
		return "OK";
	}

	/**
	 * check the user input for Login data
	 * @return boolean, if there is any error
	 */
	private boolean hasInputError() {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean hasError = false;
		
		if( email == null || email.length() < 5 ) {
			context.addMessage( "loginForm:inputUser", new FacesMessage( "Der Benutzername ist zu kurz"));
			hasError = true;
		}

		if( password == null || password.length() < 5 ) {
			context.addMessage( "loginForm:inputPWD", new FacesMessage( "Das Passwort ist zu kurz"));
			hasError = true;
		}

		return hasError;
	}

}
