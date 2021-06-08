package home365.dao;
import java.util.ArrayList; 
import java.util.List;    
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import home365.Error.AircraftNotFoundException;
import home365.Error.IncompatibleAircraftDetailException;
import home365.data.Aircraft;

@Repository
public class RdbAircraft  implements AircraftDao{
	
	private AircraftCrud aircraftCrud ;
	
	@Autowired
	public RdbAircraft(AircraftCrud aircraftCrud ) {
		
		this.aircraftCrud = aircraftCrud ;
	}

	@Override
	@Transactional()
	public Aircraft create(Aircraft aircraft) {
		
		if( ! validateAircraft(aircraft))
			throw new IncompatibleAircraftDetailException();

		return this.aircraftCrud.save(aircraft);
	
	}

	@Override
	@Transactional(readOnly = true)
	public Aircraft getAircraftById(long id) {

		Optional<Aircraft> aircraft = this.aircraftCrud.findById(id);
		
		if(aircraft.isPresent())
			return  aircraft.get();
		
		else 
			throw new AircraftNotFoundException();
	
	
	}

	@Override
	@Transactional()
	public void updateAircraft(long id, Aircraft update) {
		
		if(this.aircraftCrud.existsById(id))
			this.aircraftCrud.save(update);
		
		else 
			throw new AircraftNotFoundException();
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Aircraft> readAllAircrafts(int size, int page) {
		
		List<Aircraft> rv = new ArrayList<>();
		
		 this.aircraftCrud.findAll().forEach(rv::add)	;
		 
		 return rv  ;
	}

	
	
	
	private boolean validateAircraft(Aircraft aircraft) {

		return (	aircraft.getMaxDistance() % 1 == 0 &&
					aircraft.getPrice() % 1 == 0 );

	}

	
}
