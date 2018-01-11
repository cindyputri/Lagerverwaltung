package thi.gui.modell;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TestModell implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mailAdresse;

	public String getMailAdresse() {
		return mailAdresse;
	}

	public void setMailAdresse(String mailAdresse) {
		this.mailAdresse = mailAdresse;
	}
	
	public void doSomething() {
		
		this.mailAdresse = "Hello world " + mailAdresse;
	}
	
	
}
