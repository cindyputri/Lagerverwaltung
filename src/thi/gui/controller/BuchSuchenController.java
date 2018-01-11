package thi.gui.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import thi.common.iservices.IBuchService;

@Named
@RequestScoped
public class BuchSuchenController implements Serializable {

	private static final long serialVersionUID = 1L;
	private String keyword;
	
	@Inject
	private IBuchService buchService;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	/**
	 * @return Navigation Case, described in faces-config.xml
	 */
	public String searchBuchTyp(){
		
		if( hasInputError() ) {
			return "";
		}
		
		keyword = "*" + keyword + "*";
			
		if( buchService.getBuchTypByISBN(keyword) == null ) {
			return "NORESULT";
		}
		return "RESULTLIST";
	}
	
	/**
	 * check the user input for Search
	 * @return boolean, if there is any error
	 */
	public boolean hasInputError(){
		FacesContext context = FacesContext.getCurrentInstance();
		boolean hasError = false;
		
		if( keyword.length() > 100 ) {
			context.addMessage( "BuchSuchenForm:inputUser", new FacesMessage( "Schlüsselwort ist zu lang"));
			hasError = true;
		}

		return hasError;
	}

}
