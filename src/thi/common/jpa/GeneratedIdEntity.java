package thi.common.jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Quelle: hafenrichter ImageGalleryJSF
 *
 */
@MappedSuperclass
public class GeneratedIdEntity extends SingleIdEntity<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long identifier;

	@Override
	public Long getId() {
		return identifier;
	}
	
}
