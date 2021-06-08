package  home365.infra;

import java.time.*; 
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home365.Error.AirlineDontHaveAircraftException;
import home365.Error.DontHaveMoneyException;
import home365.dao.AircraftDao;
import home365.dao.AirlineDao;
import home365.dao.DestinationDao;
import home365.data.Aircraft;
import home365.data.Airline;
import home365.layout.BuyAircraft;

@Service
public  class AirlineServiceImpl implements AirlineService {
	
	private AirlineDao  airlineDao ; 
	private AircraftDao aircraftDao;
	private DestinationDao destinationDao ;
	
	@Autowired
	public AirlineServiceImpl(AirlineDao  airlineDao ,
			AircraftDao aircraftDao ,DestinationDao destinationDao) {
		
		super();
		this.aircraftDao = aircraftDao ;
		this.airlineDao = airlineDao ;
		this.destinationDao = destinationDao ;

	}

	@Override
	public List<Airline> readAllAirlines(int size, int page) {
		// TODO Auto-generated method stub
		
		return this.airlineDao.readAllAirlines(size, page);
	}
	

	@Override
	public Airline createAirline(Airline airline) {

		
		this.destinationDao.create(airline.getHomeBase());
		
		return this.airlineDao.create(airline);
	}


	private Airline getAirlineById(long id) {
	
		return	this.airlineDao.getAirlineById(id);
	
	}



	@Override
	public Airline addAircraftToAirlineById(long airlineId, Aircraft aircraft) {
		System.out.println(airlineId);
		Airline airline = this.getAirlineById(airlineId);
		List<Aircraft> aircrafts = airline.getAircrafts();
	
		
		if(airline.getBudjet() < aircraft.getPrice())
			throw new DontHaveMoneyException();
		
		airline.setBudjet(airline.getBudjet() - aircraft.getPrice());
		
		if(aircrafts.isEmpty())
			aircrafts = new ArrayList<Aircraft>() ;
	 
		
		aircraft.setCreationTime( LocalDate.now());
		this.aircraftDao.create(aircraft);
		
		aircrafts.add(aircraft);
		
		airline.setAircrafts(aircrafts);
		
		this.airlineDao.updateAirline(airlineId, airline);
		return airline ;
	}


	@Override
	public void sellAircraft(long airlineId, long aircraftId) {

	 Airline airline = this.getAirlineById(airlineId);
	 List<Aircraft> aircrafts = airline.getAircrafts();
	
	 if(aircrafts.isEmpty())
		
		 	throw new AirlineDontHaveAircraftException();
			
	
	 Aircraft aircraft = getAircraftById(aircraftId);
	
	
	
	 aircrafts.remove(aircraft);
		
	 double monthsBetween =	this.numOfMonth(aircraft.getCreationTime());
	
	
	 airline.setBudjet( airline.getBudjet() + aircraft.getPrice()* (1- monthsBetween* 0.02));	
		
	 airline.setAircrafts(aircrafts);
	
	 this.airlineDao.updateAirline(airlineId, airline);
	}

	
	
	@Override
	public void tradeAircrat(BuyAircraft buyAircraft) {

		
		Airline airlineBuyer = this.getAirlineById(buyAircraft.getAirlinebuyerId());
		Airline airlineSeller = this.getAirlineById(buyAircraft.getAirlineSellerId());
		
		Aircraft aircraft =	getAircraftById(buyAircraft.getAircraftId());
	
		double currentPrice = aircraft.getPrice() *
				(1 - numOfMonth(aircraft.getCreationTime())* 0.02);
		
		
		if(airlineBuyer.getBudjet() < currentPrice )
			throw new DontHaveMoneyException();
			
		aircraft.setPrice(currentPrice);
		
		aircraft.setCreationTime(LocalDate.now());
		
		sellAircraft(buyAircraft.getAirlineSellerId(), buyAircraft.getAircraftId());
		
		this.aircraftDao.updateAircraft(aircraft.getAircraft_id(), aircraft);
		
		List<Aircraft> aircrafts =  airlineBuyer.getAircrafts();
		aircrafts.add(aircraft);
		
		airlineBuyer.setAircrafts(aircrafts);
		airlineBuyer.setBudjet(airlineBuyer.getBudjet() - currentPrice);
		this.airlineDao.updateAirline(airlineBuyer.getAirline_id(), airlineSeller);
	
	}

	
	private double numOfMonth(LocalDate localdate) {
		
		long monthsBetween = ChronoUnit.MONTHS.between(
				localdate, 
				LocalDate.now()
			);
		
		return monthsBetween;
	
	}
	
	private Aircraft getAircraftById(long aircraftId) {
		
	return this.aircraftDao.getAircraftById(aircraftId);
		
	
	}

	
	

	
}
