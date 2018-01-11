package thi.common.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_STD_BESTELLUNGSPOSITION")
public class Bestellungsposition {

	@Id
	@GeneratedValue
	@Column(name="BESTPOS_ID")
	private Long identifier;
	@ManyToOne
	@JoinColumn(name="BESTPOS_BUCHTYP")
	private BuchTyp buchTyp;
	@Column(name="BESTPOS_BUCHANZAHL")
	private int buchAnzahl;
	
	Bestellungsposition(){
		super();
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public BuchTyp getBuchTyp() {
		return buchTyp;
	}

	public void setBuchTyp(BuchTyp buchTyp) {
		this.buchTyp = buchTyp;
	}

	public int getBuchAnzahl() {
		return buchAnzahl;
	}

	public void setBuchAnzahl(int buchAnzahl) {
		this.buchAnzahl = buchAnzahl;
	}
}
