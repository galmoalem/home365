package home365.infra;

import java.util.List; 

import home365.data.Destination;
import home365.layout.DestinationBoundary;

public interface DestinationService {


	public Destination createDestination (Destination destination);
	
	public List<Destination> getAvialableDestinationsByAirline (long AirlineId);

	public List<DestinationBoundary>  calcAirlineDistanceToAllDistances(long airlineId);


}
