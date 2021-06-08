package home365.dao;

import java.util.List; 

import home365.data.Destination;


public interface DestinationDao {

	
public Destination create (Destination destination);
	
	public Destination getDestinationById (long id);
	
	public List<Destination> findAll ();
}
