package thi.impl.logic;

import javax.inject.Inject;

import thi.common.iservices.IBestellungRepository;
import thi.common.iservices.IBestellungService;
import thi.common.modell.Bestellung;
import thi.common.modell.EStatusBestellung;

/**
 * Implementation Services of Bestellung
 * @author Cindy
 * @since 08.01.2018
 */
public class BestellungServiceImpl implements IBestellungService{
	
	@Inject
	private IBestellungRepository bestellungRepository;

	@Override
	public void bestellungAufnehmen( String auftragsnummer, String versandName, String versandAdresse) {

		Bestellung bestellung = new Bestellung( auftragsnummer, versandName, versandAdresse );
		bestellungRepository.createBestellung( bestellung );
		
	}

	@Override
	public void bestellungVerschicken( Bestellung bestellung ) {

		bestellungRepository.changeStatusBestellung( bestellung, EStatusBestellung.IN_BEARBEITUNG );
		
	}

}
