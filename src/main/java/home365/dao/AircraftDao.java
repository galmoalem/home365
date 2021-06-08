package home365.dao;

import java.util.List; 

import  home365.data.Aircraft;

public interface AircraftDao {

	
	
	public Aircraft create (Aircraft aircraft);
	
	public Aircraft getAircraftById (long id);
	
	public void updateAircraft (long id, Aircraft update);

	public List<Aircraft> readAllAircrafts(int size, int page);
	
	
	
	
}
