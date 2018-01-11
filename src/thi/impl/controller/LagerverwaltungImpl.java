package thi.impl.controller;

import javax.inject.Inject;

import thi.common.iservices.IBestellungService;
import thi.common.iservices.IBuchService;
import thi.common.iservices.ILagerverwaltung;
import thi.common.iservices.IRegalService;
import thi.common.modell.Bestellung;
import thi.common.modell.BuchExemplar;
import thi.common.modell.Regal;

/**
 * Implementation of Lagerverwaltung Services
 * 
 * @author Cindy
 * @since 08.01.2018
 */
public class LagerverwaltungImpl implements ILagerverwaltung {
	
	@Inject
	private IRegalService regalService;
	@Inject
	private IBuchService buchService;
	@Inject
	private IBestellungService bestellungService;

	@Override
	public void RegalAnlegen() {
		regalService.createRegal();		
	}

	@Override
	public void RegalLoeschen( Regal regal ) {
		regalService.deleteRegal( regal );
	}

	@Override
	public void BuchEinlagern( BuchExemplar buchExemplar, Regal zielregal ) {
		buchService.buchEinlagern( buchExemplar, zielregal );
	}

	@Override
	public void BuchUmlagern( BuchExemplar buchExemplar, Regal zielregal ) {
		buchService.buchUmlagern( buchExemplar, zielregal );
	}

	@Override
	public void BuchAuslagern( BuchExemplar buchExemplar ) {
		buchService.buchAuslagern( buchExemplar );
	}

	@Override
	public void BestellungVerschicken( Bestellung bestellung ) {
		bestellungService.bestellungVerschicken( bestellung );
	}

}
