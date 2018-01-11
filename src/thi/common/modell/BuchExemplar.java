package thi.common.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_STD_BUCHEXEMPLAR")
public class BuchExemplar {

	@Id
	@GeneratedValue
	@Column(name="BE_ID")
	private Long identifier;
	@ManyToOne
	@JoinColumn(name="BE_BUCHTYP_ID", referencedColumnName = "BT_ID")
	private BuchTyp buchTyp;
	@ManyToOne
	@JoinColumn(name="BE_REGAL_ID", referencedColumnName = "REG_ID")
	private Regal regal;
	
	public BuchExemplar(){
		super();
	}

	public BuchExemplar(BuchTyp buchTyp){
		super();
		this.buchTyp = buchTyp;
	}
	
	public BuchExemplar(BuchTyp buchTyp, Regal regal){
		super();
		this.buchTyp = buchTyp;
		this.regal = regal;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long buchExemplarId) {
		this.identifier = buchExemplarId;
	}

	public BuchTyp getBuchTyp() {
		return buchTyp;
	}

	public void setBuchTyp(BuchTyp buchTyp) {
		this.buchTyp = buchTyp;
	}

	public Regal getRegal() {
		return regal;
	}

	public void setRegal(Regal regal) {
		this.regal = regal;
	}
}
