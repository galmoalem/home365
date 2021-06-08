package  home365.layout;

import  home365.data.Airline;
import home365.data.Destination;

public class AirlineBoundary {


	private String name ;
	
	private double budjet;
	
	private Destination homeBase ;
	
   
	
	public AirlineBoundary() {
		
	}

	
	public AirlineBoundary(Airline entity) {
		
		
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
	
	
	public Airline toEntity() {
		
		
		Airline air = new Airline();
		
		if(this.getName() != null )
			air.setName(this.getName());
		
		if(this.getHomeBase() != null)
			air.setHomeBase(this.getHomeBase());
		
		return air ;
	}
	
	
}
