package  home365.infra;

import java.util.List;  

import  home365.data.Aircraft;
import  home365.data.Airline;
import home365.layout.BuyAircraft;

public interface AirlineService {



	public Airline createAirline (Airline airline);
	
	public List<Airline> readAllAirlines(int size, int page);

	public Airline addAircraftToAirlineById (long AirlineId ,Aircraft aircraft );
	
	
	public void sellAircraft(long airlineId , long aircraftId ) ;
	

	public void tradeAircrat(BuyAircraft buyAircraft);

	

}
