package home365.layout;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import home365.Error.AirlineNotFoundException;
import home365.Error.DestinationAlreadyExistException;
import home365.Error.DestinationNotFoundException;
import home365.Error.IncompatibleDestinationDetailException;
import home365.data.Destination;
import home365.infra.DestinationService;

@RestController
public class DestinationController {

	
	private final String baseUrl="/destination";

	private DestinationService destinationService;
	
	
	@Autowired
	public DestinationController(DestinationService destinationService) {
		
		this.destinationService = destinationService ;

	}
	
	
	
	@RequestMapping(path = baseUrl + "/create", 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Destination createDestination(@RequestBody Destination destination) {
		
		
		return this.destinationService.createDestination(destination);
		
	}
	
	
	
	@RequestMapping(path = baseUrl+"/distances/{airline_id}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DestinationBoundary> calculateAirlineToAllDistances(@PathVariable("airline_id") long airlineId) {
		
		
		return this.destinationService.calcAirlineDistanceToAllDistances(airlineId);
		
	}
	
	
	@RequestMapping(path = baseUrl+"/available/{airline_id}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Destination> getAvailableDistancesToAirline(@PathVariable("airline_id") long airlineId) {
		
		
		return this.destinationService.getAvialableDestinationsByAirline(airlineId);
		
	}
	
	
	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, Object> handleError (DestinationNotFoundException e){
		String message = e.getMessage();
		if (message == null || message.trim().length() == 0) {
			message = "Destination Not Found";
		}
		return Collections.singletonMap("error", message);
	}
	


	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleError (IncompatibleDestinationDetailException e){
		String message = e.getMessage();
		if (message == null || message.trim().length() == 0) {
			message = "Destination properties are incorrect";
		}
		return Collections.singletonMap("error", message);
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, Object> handleError (AirlineNotFoundException e){
		String message = e.getMessage();
		if (message == null || message.trim().length() == 0) {
			message = "Airline Not Found";
		}
		return Collections.singletonMap("error", message);
	}
}
