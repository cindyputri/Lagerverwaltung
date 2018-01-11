package thi.common.iservices;

import thi.common.modell.BuchTyp;

/**
 * This interface defines the abstract view of an Onlineshop service
 * that has all methods necessary to manage business logic level
 * of Onlineshop objects
 * 
 * @author Cindy
 * @since 08.01.2018
 */
public interface IOnlineshop {

	/**
	 * Get the amount of a BuchTyp in Lager
	 * @param buch
	 * @return int Anzahl
	 */
	public int LagerbestandPruefen( BuchTyp buchTyp );
	
	/**
	 * Create a BuchTyp
	 * @param isbn
	 * @param titel
	 */
	public void BuchAnlegen( String isbn );
	
	/**
	 * Create a Bestellung
	 * @param auftragsnummer
	 * @param versandName
	 * @param versandAdresse
	 */
	public void BestellungAufnehmen( String auftragsnummer, String versandName, String versandAdresse );
}
