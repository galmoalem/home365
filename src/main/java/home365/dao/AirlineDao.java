package home365.dao;


import java.util.List;  

import  home365.data.Airline;

public interface AirlineDao {

	
	

	public Airline create (Airline airline);
	
	public Airline getAirlineById (long id);
	
	
	public void updateAirline (long id, Airline update);

	
	
	public List<Airline> readAllAirlines(int size, int page);
	
	
	
	
}
