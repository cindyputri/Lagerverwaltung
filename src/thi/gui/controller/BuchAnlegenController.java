package thi.gui.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import thi.common.iservices.IOnlineshop;

@Named
@RequestScoped
public class BuchAnlegenController implements Serializable {

	private static final long serialVersionUID = 1L;
	private String isbn;
	private String titel;
	
	@Inject
	private IOnlineshop onlineshop;
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	
	/**
	 * Create a book
	 * @return String as navigation-rule, described in faces config
	 */
	public String buchAnlegen(){
		
		if( hasInputError() ) {
			return "";
		}
			
		onlineshop.BuchAnlegen(isbn);
		return ""; //"OK"
	}
	
	/**
	 * check the user input for CreateBuch data
	 * @return boolean, if there is any error
	 */
	public boolean hasInputError(){
		FacesContext context = FacesContext.getCurrentInstance();
		boolean hasError = false;
		
		if( isbn == null || isbn.length() < 13 ) {
			context.addMessage( "buchAnlegenForm:inputISBN", new FacesMessage( "ISBN Nummer ist zu kurz" ));
			hasError = true;
		}

		if( titel == null || titel.length() < 5 ) {
			context.addMessage( "buchAnlegenForm:inputTitel", new FacesMessage( "Der Titel ist zu kurz" ));
			hasError = true;
		}

		return hasError;
	}
}
