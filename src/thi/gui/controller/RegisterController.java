package thi.gui.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import thi.common.iservices.EeaLibraryException;
import thi.common.iservices.IBenutzerkontoService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
public class RegisterController {
	
	private String email;
	private String password;
	private String confirmation;
	
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
	
	public String getConfirmation() {
		return confirmation;
	}
	
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	
	public String onCreateUser() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		boolean hasError = false;
		
		if( confirmation == null || password == null || password.equals( confirmation ) == false ) {
			
			context.addMessage( null, new FacesMessage( 	FacesMessage.SEVERITY_FATAL,
															"Mismatch in password and confirmation", 
															"" ) );

			hasError = true;
		}
		
		if( hasError ) {
			return "";
		}
		
		try {
			
			benutzerkontoService.createUser( email , password );
			
		} catch (EeaLibraryException e) {

			context.addMessage( null, new FacesMessage( 	FacesMessage.SEVERITY_FATAL,
															e.getMessage(), 
															"" ) );

			for( String message : e.getDetailErrors() ) {
				context.addMessage( null, new FacesMessage( 	FacesMessage.SEVERITY_FATAL,
																message, 
																"" ) );
			}
			
			return "";
		}

		return "BACK";
	}
}
