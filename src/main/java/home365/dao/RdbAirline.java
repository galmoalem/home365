package  home365.dao;

import java.util.ArrayList; 
import java.util.List;   
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import home365.Error.AirlineNotFoundException;
import home365.Error.IncompatibleAirlineDetailException;
import  home365.data.Airline;

@Repository
public class RdbAirline implements AirlineDao {

	private AirlineCrud airlineCrud;
	
	@Autowired()
	public RdbAirline(AirlineCrud airlineCrud) {
		super();
		this.airlineCrud = airlineCrud;;
	}

	@Override
	@Transactional()
	public Airline create(Airline airline) {
		

		if ( ! validateAirline(airline))
				throw new IncompatibleAirlineDetailException();
	
	
		return	this.airlineCrud.save(airline);
	}

	@Override
	@Transactional(readOnly = true)
	public Airline getAirlineById(long id) {

		Optional<Airline> airline = this.airlineCrud.findById(id);
	
		if(airline.isPresent()) {
			
			return airline.get() ;
		
		} else {
			
			throw new AirlineNotFoundException();
			
		}
		
	}

	@Override
	@Transactional( )
	public void updateAirline(long id, Airline update) {
		
		if(this.airlineCrud.existsById(id))
			this.airlineCrud.save(update);
		
		else 
			throw new AirlineNotFoundException();
	}



	@Override
	@Transactional(readOnly = true)
	public List<Airline> readAllAirlines(int size, int page) {

		List<Airline> rv = new ArrayList<>();

		 this.airlineCrud.findAll(PageRequest.of(page, size)).getContent().forEach(rv::add)	;
		 
		 if(rv.isEmpty())
			 throw new AirlineNotFoundException();
		 
		 return rv ;
	}


	
	private boolean validateAirline(Airline airline) {
		
		return (airline.getName() != null &&
				!airline.getName().trim().isEmpty() &&
				airline.getBudjet() %1 == 0);
				
	}
	
}
