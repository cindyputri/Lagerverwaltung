package thi.impl.controller;

import javax.inject.Inject;

import thi.common.iservices.IBestellungService;
import thi.common.iservices.IBuchService;
import thi.common.iservices.IOnlineshop;
import thi.common.modell.BuchTyp;

/**
 * Implementation of Onlineshop Services
 * @author Cindy
 * @since 08.01.2018
 */
public class OnlineshopImpl implements IOnlineshop{
		
	@Inject
	private IBuchService buchService;
	@Inject
	private IBestellungService bestellungService;
	
	
	@Override
	public int LagerbestandPruefen( BuchTyp buchTyp ) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void BuchAnlegen( String isbn ) {
		buchService.createBuch( isbn );
	}

	@Override
	public void BestellungAufnehmen( String auftragsnummer, String versandName, String versandAdresse ) {
		bestellungService.bestellungAufnehmen( auftragsnummer, versandName, versandAdresse );
	}

}
