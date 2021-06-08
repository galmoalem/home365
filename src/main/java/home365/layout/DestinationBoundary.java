package  home365.layout;

import  home365.data.Destination;
import  home365.data.Location;

public class DestinationBoundary {

	
	private long id ;
	private String name ;
	
	private Location location;
	
	private double distanceFromAirline;


	public DestinationBoundary() {
		
	}


	public DestinationBoundary(double distance, Destination destination) {

		this.setDistanceFromAirline(distance);
		this.setLocation(destination.getLocation());
		this.setName(destination.getName());
		this.setId(destination.getDest_id());
	
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public double getDistanceFromAirline() {
		return distanceFromAirline;
	}


	public void setDistanceFromAirline(double distanceFromAirline) {
		this.distanceFromAirline = distanceFromAirline;
	}
	
	
	
}
