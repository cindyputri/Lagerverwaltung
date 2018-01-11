package thi.impl.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import thi.common.iservices.IBenutzerkontoRepository;
import thi.common.modell.Benutzerkonto;

/**
 * This class implements a user/benutzerkonto repository on basis of jpa 
 * and a relational database
 * @author Cindy 
 * @since 27.12.2017
 */
@ApplicationScoped
public class BenutzerkontoRepositoryImpl implements IBenutzerkontoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(TxType.REQUIRED)
	public Benutzerkonto loadUser(String email) {
		
		TypedQuery<Benutzerkonto> userQuery = entityManager.createQuery( "SELECT a FROM Benutzerkonto AS a where a.email = :email", Benutzerkonto.class );
		userQuery.setParameter("email", email );
		
		List<Benutzerkonto> result  = userQuery.getResultList();
		
		if( result == null || result.size() == 0 ) {
			return null;
		}
		
		return result.get( 0 );
	}
	
	/**
	 * Initialize the Benutzerkonto repository
	 */	
	@Override
	@Transactional(TxType.REQUIRES_NEW)
	public void initRepository() {
		
		try {
			initBenutzerkonto();
		}
		catch( RuntimeException e ) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * Initialize the Benutzerkonto repository
	 */
	public void initBenutzerkonto(){
		if(loadUser("tom@lager.com") == null){
			Benutzerkonto u1 = new Benutzerkonto( "tom@lager.com","Tom123" );
			u1.setLagerRechte( true );
			entityManager.persist( u1 );
		}
		if(loadUser("lea@lager.com") == null){
			Benutzerkonto u2 = new Benutzerkonto( "lea@lager.com","Lea123" );
			u2.setLagerRechte( true );
			entityManager.persist( u2 );
		}
		if(loadUser("lili@lager.com") == null){
			Benutzerkonto u3 = new Benutzerkonto( "lili@lager.com","Lili123" );
			u3.setLagerRechte( true );
			entityManager.persist( u3 );
		}
		if(loadUser("ol@ol.com") == null){
			Benutzerkonto u4 = new Benutzerkonto( "ol@ol.com","Ol123" );
			u4.setLagerRechte( false );
			entityManager.persist( u4 );
		}
	}

	@Override
	@Transactional(TxType.REQUIRES_NEW)
	public void createUser(Benutzerkonto benutzerkonto) {
		entityManager.persist( benutzerkonto );
	}

}
