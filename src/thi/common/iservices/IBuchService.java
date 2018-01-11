package thi.common.iservices;

import java.util.List;

import thi.common.modell.BuchExemplar;
import thi.common.modell.BuchTyp;
import thi.common.modell.Regal;

/**
 * This interface defines the abstract view of a Buch service
 * that has all methods necessary to manage business logic level
 * of BuchTyp and BuchExemplar objects
 * 
 * @author cindy
 *
 */
public interface IBuchService {
	
	/**
	 * Buch Anlegen
	 * @param String isbn
	 * @throws EeaLibraryException 
	 */
	public void createBuch( String isbn );
	
	/**
	 * Search Function to find book by keyword
	 * @param keyword can be a part of ISBN
	 * @return List of possible BuchTyps
	 */
	public List<BuchTyp> searchBook( String keyword );
	
	/**
	 * Put the book exemplar in the Regal
	 * @param buchExemplar
	 * @param regal
	 */
	public void buchEinlagern(BuchExemplar buchExemplar, Regal regal);
	
	/**
	 * Put the book exemplar in the new Regal
	 * @param buchExemplar
	 * @param neuRegal
	 */
	public void buchUmlagern(BuchExemplar buchExemplar, Regal neuRegal);
	
	/**
	 * Take the book exemplar out 
	 * @param buchExemplar
	 */
	public void buchAuslagern(BuchExemplar buchExemplar);
	
	/**
	 * Get all Book
	 * @return List of all BuchTyp
	 */
	public List<BuchTyp> getBuchTyps();

	/**
	 * Get Book Type from the given isbn
	 * unnecessary characters will be deleted
	 * @param isbn String
	 * @return List of BuchTyps
	 */
	public List<BuchTyp> getBuchTypByISBN(String isbn);

}