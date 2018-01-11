/* This class defines the basic repository operations needed to
 * maintain Regal
 * 
 * @author Cindy
 */

package thi.common.iservices;

import thi.common.modell.Regal;

/**
 * This class defines the basic repository operations needed to
 * maintain regal in the gallery
 * 
 * @author Cindy
 *
 */
public interface IRegalRepository {
	
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
