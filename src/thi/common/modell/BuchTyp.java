package thi.common.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="BuchTyp") //was JPQL zugreifft
@Table(name="TBL_STD_BUCHTYP")
public class BuchTyp {

	@Id
	@GeneratedValue
	@Column(name="BT_ID")
	private Long identifier;
	@Column(name="BT_ISBN")
	private String isbn;
	
	public BuchTyp(){
		super();
	}
	
	public BuchTyp(String isbn){
		super();
		this.isbn = isbn;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
