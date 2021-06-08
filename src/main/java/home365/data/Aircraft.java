package  home365.data;

import java.time.LocalDate; 

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity()
@Table(name = "aircraft")
public class Aircraft {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aircraft_id;
	
	private double price ;
	
	private double maxDistance;
	
	private LocalDate creationTime;
	


	public LocalDate getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(LocalDate creationTime) {
		this.creationTime = creationTime;
	}


	public Aircraft() {
		
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}


	@Override
	public String toString() {
		return "Aircraft [aircraft_id=" + aircraft_id + ", price=" + price + ", maxDistance=" + maxDistance + "]";
	}

	@Temporal(TemporalType.TIMESTAMP)
	public long getAircraft_id() {
		return aircraft_id;
	}


	public void setAircraft_id(long aircraft_id) {
		this.aircraft_id = aircraft_id;
	}


	
	
	
}
