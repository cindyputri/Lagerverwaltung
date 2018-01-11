package thi.impl.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import thi.common.iservices.IRegalRepository;
import thi.common.modell.Regal;

/**
 * This class implements a regal repository on basis of jpa 
 * and a relational database
 * @author Cindy
 * @since 08.01.2018
 */
public class RegalRepositoryImpl implements IRegalRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(TxType.REQUIRES_NEW)
	public void createRegal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public void deleteRegal( Regal regal ) {
		
		try{
			regal = entityManager.merge( regal );
			entityManager.remove( regal );
		}
		catch( Exception e ){
			e.printStackTrace();
		}
		
	}

}
