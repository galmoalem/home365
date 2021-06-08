package home365.infra;

import java.util.ArrayList; 
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grum.geocalc.Coordinate;
import com.grum.geocalc.EarthCalc;
import com.grum.geocalc.Point;

import home365.dao.AirlineDao;
import home365.dao.DestinationDao;
import home365.data.Aircraft;
import home365.data.Airline;
import home365.data.Destination;
import home365.layout.DestinationBoundary;

@Service
public class DestinationServiceImpl implements DestinationService {

	private AirlineDao airlineDao ;
	private DestinationDao destinationDao ;
	
	@Autowired
	public DestinationServiceImpl(DestinationDao destinationDao , AirlineDao airlineDao) {
		super();
		this.airlineDao = airlineDao ;
		this.destinationDao =  destinationDao ;
	}

	@Override
	public Destination createDestination(Destination destination) {


		return	this.destinationDao.create(destination);
	
	}

	

		
	

	@Override
	public List<Destination> getAvialableDestinationsByAirline(long AirlineId) {

		double maxDistanceOfAircraft = 0 ;

		Airline airline = this.airlineDao.getAirlineById(AirlineId);

		List<DestinationBoundary> destsBoundry = calcAirlineDistanceToAllDistances(AirlineId);
		
		maxDistanceOfAircraft = this.getMaxDistance(airline.getAircrafts());
	
		final double  maxDistance = maxDistanceOfAircraft;
		
		
			return destsBoundry.stream().filter(a -> a.getDistanceFromAirline() <=  maxDistance)
					.map(dest -> (new Destination(dest)))
					.collect(Collectors.toList());
	}
	
	@Override
	public List<DestinationBoundary> calcAirlineDistanceToAllDistances(long airlineId) {
		
		Airline airline = this.airlineDao.getAirlineById
					(airlineId);
		
		List<Destination> dests = this.destinationDao.findAll();
		Coordinate lat = Coordinate.fromDegrees(airline.getHomeBase().getLocation().getAltitude());
		Coordinate lng = Coordinate.fromDegrees(airline.getHomeBase().getLocation().getLongtiude());
	
		Point myPoint = Point.at(lat, lng);
		
		return calcHaversine(myPoint , dests);
	}
	
	private double getMaxDistance(List<Aircraft> aircrafts) {
		
		double max = 0 ;
		for (Aircraft aircraft : aircrafts) {
			
			if(aircraft.getMaxDistance() > max)
					
				max = aircraft.getMaxDistance();
			
		}
		
		return max;
		
	}
	
private List<DestinationBoundary> calcHaversine(Point myPoint , List<Destination> destinations){
		
		Coordinate lat = Coordinate.fromDegrees(0);
		Coordinate lng = Coordinate.fromDegrees(0);
		
		List<DestinationBoundary> destinationsBoundry =new ArrayList<DestinationBoundary>();
		
		double distance = 0 ;

		for (Destination destination : destinations) {
		
			lat = Coordinate.fromDegrees(destination.getLocation().getAltitude());
			
			lng = Coordinate.fromDegrees(destination.getLocation().getLongtiude());
		
			Point destPoint = Point.at(lat, lng);
			
			if(! destPoint.equals(myPoint)) {
						
				distance = EarthCalc.haversine.distance(myPoint, destPoint);
				
				DestinationBoundary destBoundry = new DestinationBoundary(distance , destination); 
				
				destinationsBoundry.add(destBoundry);
			}
		
					}
		return destinationsBoundry;
				}




}
	
	
	
	

