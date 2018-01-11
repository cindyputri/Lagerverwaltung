package thi.common.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Benutzerkonto")
@Table(name="TBL_STD_BENUTZERKONTO")
public class Benutzerkonto {
	
	@Id
	@GeneratedValue
	@Column(name="BK_ID")
	private Long identifier;
	@Column(name="BK_EMAIL")
	private String email;
	@Column(name="BK_PASSWORD")
	private String password;
	@Column(name="BK_LAGERRECHTE")
	private boolean lagerRechte;
	
	public Benutzerkonto() {
		super();
		this.lagerRechte = false;
	}
	public Benutzerkonto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLagerRechte() {
		return lagerRechte;
	}

	public void setLagerRechte(boolean lagerRechte) {
		this.lagerRechte = lagerRechte;
	}
}
