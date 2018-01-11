package thi.common.iservices;

/**
 * This interface defines the abstract view of a benutzerkonto service
 * that has all methods necessary to manage business logic level
 * of benutzerkonto objects
 * 
 * @author cindy
 *
 */
public interface IBenutzerkontoService {
	
	/**
	 * Login User
	 * 
	 * @param email
	 * @param password
	 * @return boolean: success or not
	 */
	public boolean login( String email, String password );
	
	/**
	 * Create a new user account
	 * 
	 * @param email
	 * @param password
	 * @throws EeaLibraryException 
	 */
	public void createUser( String email, String password ) throws EeaLibraryException;
	
	/**
	 * Get email of currently logged in user
	 * 
	 * @return 
	 */
	public String getCurrentUser();

}
