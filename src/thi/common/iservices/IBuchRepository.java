package thi.common.iservices;

import java.util.List;

import thi.common.modell.BuchExemplar;
import thi.common.modell.BuchTyp;

/**
 * This interface defines the abstract view of a Buch repository
 * that has all methods necessary to manage persistent representation
 * of BuchTyp and BuchExemplar objects
 * 
 * @author Cindy
 *
 */
public interface IBuchRepository {
	
	/**
	 * Buch Anlegen in the Database
	 * @param buchTyp
	 * @param buchExemplar
	 */
	public void createBuch(BuchTyp buchTyp, BuchExemplar buchExemplar);
	
	/**
	 * Get Book Type from the given isbn
	 * @param isbn String
	 * @return BuchTyp
	 */
	public List<BuchTyp> getBuchTypByISBN(String isbn);
		
	/**
	 * Get Book exemplar and put them in a list
	 * @param vonBuchTyp BuchTyp
	 * @return List of books
	 */
	public List<BuchExemplar> getBuchExemplar(BuchTyp vonBuchTyp);

}
