package thi.common.modell;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

/**
 * This objects represents the current user that is actually logged in
 * 
 * @author hafenrichter
 *
 */
@SessionScoped
public class UserSession implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userId;

	public UserSession() {
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
}
