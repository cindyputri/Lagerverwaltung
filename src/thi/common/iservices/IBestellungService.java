package thi.common.iservices;

import thi.common.modell.Bestellung;

/**
 * This interface defines the abstract view of a Bestellung service
 * that has all methods necessary to manage business logic level
 * of Bestellung objects
 * 
 * @author Cindy
 * @since 08.01.2018
 */
public interface IBestellungService {

	/**
	 * Online Shop kann Bestellung aufnehmen.
	 * Create Bestellung in der Repository
	 * @param auftragsnummer
	 * @param versandName
	 * @param versandAdresse
	 */
	public void bestellungAufnehmen( String auftragsnummer, String versandName, String versandAdresse );
	
	/**
	 * Lagerist kann die Bestellung verschicken
	 * @param bestellung
	 */
	public void bestellungVerschicken ( Bestellung bestellung );	
	

}
