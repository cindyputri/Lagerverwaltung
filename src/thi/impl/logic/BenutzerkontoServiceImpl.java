package thi.impl.logic;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

import thi.common.iservices.EeaLibraryException;
import thi.common.iservices.IBenutzerkontoRepository;
import thi.common.iservices.IBenutzerkontoService;
import thi.common.modell.Benutzerkonto;
import thi.common.modell.UserSession;

/**
 * Implementation Services of User Account
 * @author Cindy
 *
 */
@ApplicationScoped
public class BenutzerkontoServiceImpl implements IBenutzerkontoService{
	
	@Inject
	private UserSession currentUser;
	
	@Inject
	private IBenutzerkontoRepository benutzerkontoRepository;
	

	@Override
	public boolean login(String email, String password) {
		
		//initialize Users in Repository
		benutzerkontoRepository.initRepository();

		Benutzerkonto userAccount = benutzerkontoRepository.loadUser(email);
		//if null, return false
		if(userAccount == null){
			return false;
		}
		//else if false Email &/ Pass
		if( userAccount.getEmail().equals( email ) == false || userAccount.getPassword().equals( password ) == false ) {
			return false;
		}
		//else
		currentUser.setUserId( email );
		return true;
	}


	@Override
	public String getCurrentUser() {
		return currentUser.getUserId();
	}


	@Override
	public void createUser(String email, String password) throws EeaLibraryException {
		Benutzerkonto user  = new Benutzerkonto( email, password );
		checkUserData( user );
		benutzerkontoRepository.createUser( user );		
	}

	private void checkUserData( Benutzerkonto konto ) throws EeaLibraryException {
		
		List<String> result = new ArrayList<String>();
		
		if( konto.getEmail() == null || konto.getEmail().length() < 5 ) {
			result.add( "Username has invalid length; At least 5" ); 
		}

		
		if( konto.getPassword() == null || konto.getPassword().length() < 5 ) {
			result.add( "Password has invalid length; At least 5" ); 
		}

		if( result.size() > 0 ) {
			throw new EeaLibraryException( "Invalid user input" , result );
		}
	}

}
