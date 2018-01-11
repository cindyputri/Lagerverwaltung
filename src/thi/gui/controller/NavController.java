package thi.gui.controller;

import javax.enterprise.context.RequestScoped;

/**
 * 
 * Grundlage: https://www.tutorialspoint.com/jsf/jsf_page_navigation.htm
 * 
 * @author Cindy
 */
@RequestScoped
public class NavController {
	
//	@ManagedProperty(value = "#{navController.pageId}")
	private String pageId;

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	
	public boolean isAdmin() {
		return true;
	}

	/**
	 * @return String  navigate the page
	 */
	public String showPage() {
		if (pageId == null) {
			return "Welcome";
		}
		//change to switch
		if (pageId.equals("Buch")) {
			return "Buch";
		} else if (pageId.equals("Regal")) {
			return "Regal";
		} else if (pageId.equals("Bestellung")) {
			return "Bestellung";
		} else if (pageId.equals("Benutzerkonto")) {
			return "Benutzerkonto";
		} else if (pageId.equals("SignOut")) {
			return "SignOut";
		}		
		else {
			return "home";
		}
	}
}
