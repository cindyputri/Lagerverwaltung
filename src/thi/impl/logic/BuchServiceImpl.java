package thi.impl.logic;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import thi.common.iservices.IBuchRepository;
import thi.common.iservices.IBuchService;
import thi.common.modell.BuchExemplar;
import thi.common.modell.BuchTyp;
import thi.common.modell.Regal;

/**
 * Implementation Services of Buch (Typ & Exemplar)
 * @author Cindy
 * @since 05.01.2018
 */
public class BuchServiceImpl implements IBuchService{
	
	@Inject
	private IBuchRepository buchRepository;

	@Override
	public void createBuch( String isbn ) {

		BuchTyp buchTyp = getBuch( isbn );
		BuchExemplar buchExemplar = new BuchExemplar(buchTyp);
		
		buchRepository.createBuch(buchTyp, buchExemplar);
	}
	
	/**
	 * Get Buch with given isbn.
	 * 	If not found, then create a new BuchTyp
	 * @param isbn
	 * @param titel
	 * @return BuchTyp
	 */
	public BuchTyp getBuch( String isbn ){
		
		List<BuchTyp> listBuchTyp = new ArrayList<BuchTyp>();
		listBuchTyp = buchRepository.getBuchTypByISBN(isbn);
		BuchTyp buchTyp = new BuchTyp( isbn );
		if (listBuchTyp != null && listBuchTyp.size() > 0) {
				buchTyp = listBuchTyp.get(0);
		}
				
		return buchTyp;
	}

	@Override
	public List<BuchTyp> searchBook(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buchEinlagern(BuchExemplar buchExemplar, Regal regal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buchUmlagern( BuchExemplar buchExemplar, Regal neuRegal ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buchAuslagern( BuchExemplar buchExemplar ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BuchTyp> getBuchTypByISBN( String isbn ) {
		String newISBN = cleanISBN(isbn);
		return buchRepository.getBuchTypByISBN(newISBN);
	}
	
	/**
	 * Delete all unnecessary characters
	 * @param isbn
	 * @return cleaned up ISBN
	 */
	public String cleanISBN( String isbn ){
		String cleanIsbn = "";

		cleanIsbn = isbn.replaceAll("[ -/]", "");
		if(cleanIsbn.length() > 13){
			//Throw
		}
		
		return cleanIsbn;
	}

	@Override
	public List<BuchTyp> getBuchTyps() {
		// TODO Auto-generated method stub
		return null;
	}

}
