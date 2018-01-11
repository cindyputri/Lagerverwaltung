package thi.common.jpa;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;

/**
 * Basisklasse für Entities mit einem einzelnen ID-Attribut.
 * Quelle: hafenrichter ImageGalleryJSF
 * @param <K>
 *            Typ des ID-Attributs
 */

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class SingleIdEntity<K> {

	public abstract K getId();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		K thisId = getId();
		return thisId != null ? thisId.hashCode() : 0;
	}

	/**
	 * Vergleich dieses Objektes mit einem anderen.
	 * 
	 * Zwei Objekte vom Typ SingleKeyEntity werden als gleich eingestuft, wenn
	 * sie gleichen Typs sind und ihre Ids gesetzt und gleich sind.
	 * 
	 * Achtung: Ist die Id mindestens eines der beiden Objekte <code>null</code>
	 * , werden die Objekte als 'ungleich' erachtet. Die Annahme ist, dass die
	 * Id einer Entity nur dann <code>null</code> ist, wenn sie eine generierte
	 * Id besitzt und noch nicht persistiert wurde. In diesem Fall wird
	 * wahrscheinlich kein Vergleich mit einem inhaltsgleichen Objekt
	 * durchgeführt, so dass <code>false</code> als Ergebnis sinnvoll erscheint.
	 * 
	 * @param obj
	 *            Vergleichsobjekt
	 * @return <code>true</code> bei Gleichheit
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}

		@SuppressWarnings("unchecked")
		final SingleIdEntity<K> other = (SingleIdEntity<K>) obj;

		K thisId = getId();
		K otherId = other.getId();

		return thisId != null && thisId.equals(otherId);
	}

}