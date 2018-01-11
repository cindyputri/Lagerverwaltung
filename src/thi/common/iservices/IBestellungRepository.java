package thi.common.iservices;

import java.util.List;

import thi.common.modell.Benutzerkonto;
import thi.common.modell.Bestellung;
import thi.common.modell.EStatusBestellung;

/**
 * This interface defines the abstract view of a Bestellung repository
 * that has all methods necessary to manage persistent representation
 * of Bestellung objects
 * 
 * @author Cindy
 * @since 08.01.2018
 */
public interface IBestellungRepository {

	/**
	 * @param bestellung
	 */
	public void createBestellung(Bestellung bestellung);
	
	/**
	 * @param bestellung
	 * @param statusBestellung
	 */
	public void changeStatusBestellung(Bestellung bestellung, EStatusBestellung statusBestellung);
	
	/**
	 * Get / Search Bestellung by Auftragsnummer
	 * @param String toFindAuftragsnummer
	 * @return List of Bestellung
	 */
	public List<Bestellung> getBestellungByAuftragsnummer( String toFindAuftragsnummer );
	
	/**
	 * Get / Search Bestellung by Versand Name
	 * @param String toFindVersandName
	 * @return List of Bestellung
	 */
	public List<Bestellung> getBestellungByVersandName( String toFindVersandName );
	/**
	 * Get / Search Bestellung by Status
	 * @param Enum status
	 * @return List of Bestellung
	 */
	public List<Bestellung> getBestellungByStatus( EStatusBestellung status );
	
	/**
	 * Get / Search Bestellung by Bearbeiter
	 * @param Benutzerkonto bearbeiter
	 * @return List of Bestellung
	 */
	public List<Bestellung> getBestellungByBearbeiter( Benutzerkonto bearbeiter );
}
