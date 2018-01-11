package thi.common.iservices;

import thi.common.modell.Bestellung;
import thi.common.modell.BuchExemplar;
import thi.common.modell.Regal;

/**
 * This class defines the business logic for maintaining
 * a Lagerverwaltung Object
 * 
 * @author Cindy
 * @since 08.01.2018
 */
public interface ILagerverwaltung {
	
	/**
	 * Create Regal
	 * Identifier / ID will be given automatically
	 */
	public void RegalAnlegen();
	
	/**
	 * Delete given regal
	 * @param regal
	 */
	public void RegalLoeschen( Regal regal );
	
	/**
	 * Put the given book in the given shelf
	 * @param BuchExemplar buch
	 * @param Regal zielregal
	 */
	public void BuchEinlagern( BuchExemplar buch, Regal zielregal );
	
	/**
	 * Move the given book in the given shelf
	 * @param BuchExemplar buch
	 * @param Regal zielregal
	 */
	public void BuchUmlagern( BuchExemplar buch, Regal zielregal );

	/**
	 * Take out the given book from the shelf
	 * @param BuchExemplar buch
	 */
	public void BuchAuslagern( BuchExemplar buch );
	
	/**
	 * Send an order
	 * @param bestellung
	 */
	public void BestellungVerschicken( Bestellung bestellung );
}