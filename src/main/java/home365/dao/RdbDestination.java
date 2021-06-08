package home365.dao;

import java.util.ArrayList; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import home365.Error.DestinationNotFoundException;
import home365.Error.IncompatibleDestinationDetailException;
import home365.data.Destination;


@Repository
public class RdbDestination implements DestinationDao{

	private DestinationCrud  destinationCrud ; 
	
	@Autowired
	public RdbDestination(DestinationCrud  destinationCrud ) {
		super();
		this.destinationCrud = destinationCrud ;
	}

	@Override
	@Transactional()
	public Destination create(Destination destination) {
	
		if( ! valideDestination(destination))
				
			throw new IncompatibleDestinationDetailException();
	
		return this.destinationCrud.save(destination);
	}

	@Override
	@Transactional(readOnly = true)
	public Destination getDestinationById(long id) {

			Optional<Destination> dest = this.destinationCrud.findById(id);
		
			if(dest.isPresent()) {
				
				return dest.get();
			
			} else {
				
				throw new DestinationNotFoundException();
			}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Destination> findAll() {
		
		List<Destination> rv = new ArrayList<>();

		this.destinationCrud.findAll().forEach(rv::add)	;
		 
		if(rv.isEmpty())
			throw new DestinationNotFoundException();
	
		return rv ;
	}

	private boolean valideDestination(Destination dest) {

		return (dest.getName() != null &&
				!dest.getName().trim().isEmpty() &&
				dest.getLocation().getAltitude() % 1 == 0 &&
				dest.getLocation().getLongtiude() % 1 == 0	);

	}


}
