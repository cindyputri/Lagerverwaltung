package thi.common.iservices;

import thi.common.modell.Benutzerkonto;

/**
 * This interface defines the abstract view of a benutzerkonto repository
 * that has all methods necessary to manage persistent representation
 * of benutzerkonto objects
 * 
 * @author cindy
 *
 */
public interface IBenutzerkontoRepository {
	
	/**
	 * Create a benutzerkonto / user object in the database
	 * 
	 * @param benutzerkonto
	 */
	public void createUser(Benutzerkonto benutzerkonto);
	
	/**
	 * Load a user object by the given identifier
	 * 
	 * @param email of the user account
	 * @return 
	 */
	public Benutzerkonto loadUser( String email );
	
	/**
	 * Initialize the Benutzerkonto/User repository
	 */	
	public void initRepository();

}
