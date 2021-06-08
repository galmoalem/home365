package  home365.data;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import home365.layout.DestinationBoundary; 

@Entity
@Table(name = "destinations")
public class Destination {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dest_id;
	
	private String name ;
	
	private Location location;
	
	
	public Destination() {
		
	}








	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	@Embedded
	public Location getLocation() {
		return location;
	}



	public void setLocation(Location location) {
		this.location = location;
	}








	public long getDest_id() {
		return dest_id;
	}








	public void setDest_id(long dest_id) {
		this.dest_id = dest_id;
	}



	public	Destination(DestinationBoundary destBound) {
	
	this.setDest_id(destBound.getId());
	
	this.setLocation(destBound.getLocation());

	this.setName(destBound.getName());
	}




	@Override
	public String toString() {
		return "Destination [dest_id=" + dest_id + ", name=" + name + ", location=" + location + "]";
	}



	
	
}
