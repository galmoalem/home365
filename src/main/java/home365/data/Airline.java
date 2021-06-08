package home365.data;

import java.util.List; 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity()
@Table(name = "airline")

public class Airline {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long airline_id;
	
	private String name ;
	
	private double budjet;
	
	@OneToOne(targetEntity =  Destination.class)
	//@JoinColumn(name = "airline_id", referencedColumnName = "airline_id" )
	private Destination homeBase ;
	
	@OneToMany(cascade = CascadeType.ALL ,targetEntity = Aircraft.class)
   // @JoinColumn(name = "airline_id", referencedColumnName = "airline_id")
    private List<Aircraft> aircrafts;
	
	public Airline() {
		
	}

	
	public long getAirline_id() {
		return airline_id;
	}


	public void setAirline_id(long airline_id) {
		this.airline_id = airline_id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBudjet() {
		return budjet;
	}

	public void setBudjet(double budjet) {
		this.budjet = budjet;
	}

	public Destination getHomeBase() {
		return homeBase;
	}

	public void setHomeBase(Destination homeBase) {
		this.homeBase = homeBase;
	}

	public List<Aircraft> getAircrafts() {
		return aircrafts;
	}

	public void setAircrafts(List<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
	}


	@Override
	public String toString() {
		return "Airline [airline_id=" + airline_id + ", name=" + name + ", budjet=" + budjet + ", homeBase=" + homeBase
				+ ", aircrafts=" + aircrafts + "]";
	}


	
	
	
}
