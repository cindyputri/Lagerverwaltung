package thi.common.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

/*
 * Quelle: hafenrichter ImageGalleryJSF
 * Quelle: https://github.com/dirkweil/ee-demos
*/
public abstract class SingleIdEntityRepository<K, E extends SingleIdEntity<?>> implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Class<E> entityClass;
    
    @PersistenceContext
    private EntityManager em;
    
    public void persist(E entity){
        em.persist(entity);
    }
    
    @Transactional(TxType.REQUIRES_NEW)
    public E merge(E entity){
        return em.merge(entity);
    }
    
    public void remove(E entity){
        em.remove(entity);
    }
        
    public E getById(K key){
        E entity = em.find(getEntityClass(), key);
        return entity;
    }
    
    public List<E> getAll(){
        
        // SELECT c FROM Classname ORDER BY Id
        // Nutzung von Criteria-Queries (generischer Aufbau der Query �ber Objekte statt Strings)
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
        Root<E> root = criteriaQuery.from(getEntityClass());
        criteriaQuery.select(root);
    
        TypedQuery<E> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }
    
    // Klassenname ermitteln mit Hilfe Java-Reflection
    @SuppressWarnings("unchecked")
	protected Class<E> getEntityClass()
    {
        // falls Klasse noch nicht gesucht wurde, dann jetzt
        if (this.entityClass == null)
        {
            // Eigene Klasse holen
            // Der zur�ckgegebene Klassenname ist der, der konkreten (!) Klasse, nicht dieser abstrakten Klasse
            Class<?> repoClass = getClass();
            // solange...
            while (true)
            {
                // ... repoClass noch eine Klasse hat, von der sie abgeleitet ist...
                Class<?> baseClass = repoClass.getSuperclass();
                // Kurzform f�r: if(baseClass!=null) { /* was nach dem : steht */ } else { throw new AssertionViolationException() }
                // ... und die auch bitte von SingleIdEntityRepository abgeleitet sein muss ...
                assert baseClass != null : "Ihr Repository muss von Klasse " + SingleIdEntityRepository.class.getName() + " abgeleitet sein!";

                // ... solange geht die Vererbungshierarchie runter...
                if (baseClass == SingleIdEntityRepository.class)
                {
                    // ...bis zu (Gross)Vater == SingleIdEntityRepository...
                    break;
                }

                repoClass = baseClass;
            }

            // repoClass ist jetzt eine "ueber" SingleIdEntityRepository<E, K extends ...>, z. B. RandomIdEntityRepository<String>
            // mit getGenericSuperclass bekommt man Klassenobjekt vom Vater, der mit Generics parametriert ist
            Type genericSuperClass = repoClass.getGenericSuperclass();
            assert genericSuperClass instanceof ParameterizedType : SingleIdEntityRepository.class.getName() + " must be generic";

            // .. der Vater (SingleIdEntityRepository wurde mit zwei konkreten Datentypen parametriert, z. B. <String, RandomIdEntity>
            Type[] typeParms = ((ParameterizedType) genericSuperClass).getActualTypeArguments();
            assert typeParms.length == 2 : SingleIdEntityRepository.class.getName() + " muss exakt 2 Parameter besitzen, hat aber " + typeParms.length + " Parameter";

            // davon nimm den 2. Parametertyp, das ist der Datentyp der Id (des Prim�rschl�ssels)
            Type entityType = typeParms[1];

            if (entityType instanceof ParameterizedType)
            {
                entityType = ((ParameterizedType) entityType).getRawType();
            }

            assert entityType instanceof Class<?> : "Entity muss eine Klasse sein (kein Interface, Array, ...)";

            // den Datentyp braucht man, um die TypedQuery in getAll() mit dem richtigen Datentyp zu "best�cken"
            this.entityClass = (Class<E>) entityType;
        }

        // oder vom letzten mal Suchen nehmen
        return this.entityClass;
    }

}
