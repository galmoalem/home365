package  home365.data;

import javax.persistence.Embeddable;

@Embeddable
public class Location {

	@Override
	public String toString() {
		return "Location [altitude=" + altitude + ", longtiude=" + longtiude + "]";
	}



	private double altitude;
	
	private double longtiude;
	


	public Location() {
		
	}


	public double getAltitude() {
		return altitude;
	}



	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}



	public double getLongtiude() {
		return longtiude;
	}



	public void setLongtiude(double longtiude) {
		this.longtiude = longtiude;
	}



	


}

