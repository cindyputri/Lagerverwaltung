package thi.impl.logic;

import javax.inject.Inject;

import thi.common.iservices.IRegalRepository;
import thi.common.iservices.IRegalService;
import thi.common.modell.Regal;

/**
 * Implementation of Regal Services 
 * @author Cindy
 * @since 08.01.2018
 */
public class RegalServiceImpl implements IRegalService{
	
	@Inject
	private IRegalRepository regalRepository;

	@Override
	public void createRegal() {
		regalRepository.createRegal();
		
	}

	@Override
	public void deleteRegal( Regal regal ) {
		regalRepository.deleteRegal( regal );
		
	}

}
