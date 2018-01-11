package thi.common.iservices;

import thi.common.modell.Regal;

/**
 * This class defines the business logic for maintaining
 * a Regal Object
 *  
 * @author Cindy
 * @since 08.01.2018
 */
public interface IRegalService {
	
	/**
	 * Create a regal.
	 * Identifier / ID will be given automatically
	 */
	public void createRegal();
			
	/**
	 * Delete a regal with given ID
	 * @param Regal regal
	 */
	public void deleteRegal( Regal regal );

}
