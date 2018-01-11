package thi.common.modell;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_STD_BESTELLUNG")
public class Bestellung {
	
	@Id
	@GeneratedValue
	@Column(name="BEST_ID")
	private Long identifier;
	@Column(name="BEST_AUFTRAGSNUMMER")
	private String auftragsnummer;
	@Column(name="BEST_STATUS")
	private EStatusBestellung status;
	@Column(name="BEST_VERSANDNAME")
	private String versandName;
	@Column(name="BEST_VERSANDADRESSE")
	private String versandAdresse;
	@OneToMany
	@JoinColumn(name="BEST_BESTPOS_ID")
	private List<Bestellungsposition> bestellungsPositionen = new ArrayList<Bestellungsposition>();
	@ManyToOne
	@JoinColumn(name="BEST_BEARBEITER_ID")
	private Benutzerkonto bearbeiter;
	
	public Bestellung(){
		super();
	}
	
	public Bestellung( String auftragsnummer, String versandName, String versandAdresse ){
		super();
		this.auftragsnummer = auftragsnummer;
		this.versandName = versandName;
		this.versandAdresse = versandAdresse;
		this.status = EStatusBestellung.OFFEN;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getAuftragsNummer() {
		return auftragsnummer;
	}

	public void setAuftragsNummer(String auftragsNummer) {
		this.auftragsnummer = auftragsNummer;
	}

	public EStatusBestellung getStatus() {
		return status;
	}

	public void setStatus(EStatusBestellung status) {
		this.status = status;
	}

	public String getVersandName() {
		return versandName;
	}

	public void setVersandName(String versandName) {
		this.versandName = versandName;
	}

	public String getVersandAdresse() {
		return versandAdresse;
	}

	public void setVersandAdresse(String versandAdresse) {
		this.versandAdresse = versandAdresse;
	}

	public List<Bestellungsposition> getBestellungsPositionen() {
		return bestellungsPositionen;
	}

	public void setBestellungsPositionen(List<Bestellungsposition> bestellungsPositionen) {
		this.bestellungsPositionen = bestellungsPositionen;
	}

	public Benutzerkonto getBearbeiter() {
		return bearbeiter;
	}

	public void setBearbeiter(Benutzerkonto bearbeiter) {
		this.bearbeiter = bearbeiter;
	}
}
