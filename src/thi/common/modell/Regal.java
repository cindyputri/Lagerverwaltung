package thi.common.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_STD_REGAL")
public class Regal {
	
	@Id
	@GeneratedValue
	@Column(name="REG_ID")
	private int identifier;
	
	public Regal(){
		super();
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int regalId) {
		this.identifier = regalId;
	}
}
