package thi.impl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import thi.common.iservices.IBestellungRepository;
import thi.common.modell.Benutzerkonto;
import thi.common.modell.Bestellung;
import thi.common.modell.EStatusBestellung;

public class BestellungRepositoryImpl implements IBestellungRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(TxType.REQUIRES_NEW)
	public void createBestellung( Bestellung bestellung ) {
		entityManager.persist( bestellung );
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public void changeStatusBestellung(Bestellung bestellung, EStatusBestellung statusBestellung) {

		bestellung = entityManager.find(Bestellung.class, bestellung.getIdentifier());
		bestellung.setStatus( statusBestellung );
		entityManager.persist( bestellung );
		
	}

	@Override
	public List<Bestellung> getBestellungByAuftragsnummer(String toFindAuftragsnummer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bestellung> getBestellungByVersandName(String toFindVersandName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bestellung> getBestellungByStatus(EStatusBestellung status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bestellung> getBestellungByBearbeiter(Benutzerkonto bearbeiter) {
		// TODO Auto-generated method stub
		return null;
	}


}
