package thi.impl.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import thi.common.iservices.IBuchRepository;
import thi.common.modell.BuchExemplar;
import thi.common.modell.BuchTyp;

/**
 * This class implements a book repository on basis of jpa 
 * and a relational database
 * @author Cindy
 * @since 04.01.2018
 */
@ApplicationScoped
public class BuchRepositoryImpl implements IBuchRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(TxType.REQUIRES_NEW)
	public void createBuch(BuchTyp buchTyp, BuchExemplar buchExemplar) {
		entityManager.persist( buchTyp );
		entityManager.persist( buchExemplar );
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public List<BuchTyp> getBuchTypByISBN( String isbn ) {
		TypedQuery<BuchTyp> userQuery = entityManager.createQuery( "SELECT b FROM BuchTyp AS b where b.isbn LIKE :isbn", BuchTyp.class );
		userQuery.setParameter( "isbn", isbn );
		
		List<BuchTyp> result  = userQuery.getResultList();
		
		if( result == null || result.size() == 0 ) {
			return null;
		}
		
		return result;
	}
	
	@Override
	@Transactional(TxType.REQUIRED)
	public List<BuchExemplar> getBuchExemplar(BuchTyp vonBuchTyp) {
		// TODO Ask how is to search it ! 08.01.2018
		TypedQuery<BuchExemplar> userQuery = entityManager.createQuery( "SELECT e FROM BuchExemplar AS e WHERE e.identifier LIKE :id", BuchExemplar.class );
		userQuery.setParameter( "id", vonBuchTyp.getIdentifier());
		
		List<BuchExemplar> result  = userQuery.getResultList();
		
		if( result == null || result.size() == 0 ) {
			return null;
		}
		
		return result;
	}

}
