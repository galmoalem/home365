package  home365.layout;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import home365.Error.AircraftAlreadyExistException;
import home365.Error.AircraftNotFoundException;
import home365.Error.AirlineAlreadyExistException;
import home365.Error.AirlineDontHaveAircraftException;
import home365.Error.AirlineNotFoundException;
import home365.Error.DestinationNotFoundException;
import home365.Error.DontHaveMoneyException;
import home365.Error.IncompatibleAircraftDetailException;
import home365.Error.IncompatibleAirlineDetailException;
import home365.Error.IncompatibleDestinationDetailException;
import home365.data.Aircraft;
import home365.data.Airline;
import  home365.infra.AirlineService;

@RestController
public class AirlineController {

	

	private AirlineService airlineService ;
	
	private final String baseUrl="/airline";
	
	@Autowired()
	public AirlineController(AirlineService airlineService ) {
		super();
		this.airlineService =  airlineService ;
	}
	
	
	
	
	@RequestMapping(path = baseUrl + "/create",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Airline createAirline(@RequestBody Airline airline) {
		
		
		return this.airlineService.createAirline(airline);
		
	}
	
	
	@RequestMapping(path = baseUrl, 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Airline> getAirlinesWithBalance(@RequestParam(name="size", required = false, defaultValue = "10") int size,
			@RequestParam(name="page", required = false, defaultValue = "0") int page) {
	
		return this.airlineService.readAllAirlines(size, page);

	}
	
	

	
	@RequestMapping(path = baseUrl+"/aircraft/{airline_id}", 
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Airline addAircraftToairline(@PathVariable("airline_id") long airlineId ,@RequestBody Aircraft  aircraft) {
		
		
		return this.airlineService.addAircraftToAirlineById(airlineId, aircraft);
		
	}
	
	@RequestMapping(path = baseUrl + "/trade", 
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void tradeAircraft(@RequestBody BuyAircraft  buyAircraft) {
		
		
		 this.airlineService.tradeAircrat(buyAircraft);
		
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
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, Object> handleError (AircraftNotFoundException e){
		String message = e.getMessage();
		if (message == null || message.trim().length() == 0) {
			message = "Aircraft Not Found";
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
	


	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleError (IncompatibleAirlineDetailException e) {
		String message = e.getMessage();
		if (message == null || message.trim().length() == 0) {
			message = "Airline properties are incorrect";
		}
		return Collections.singletonMap("error", message);
	}
	
	
	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, Object> handleError (AirlineDontHaveAircraftException e){
		String message = e.getMessage();
		if (message == null || message.trim().length() == 0) {
			message = "Airline Dont Have Aircraft";
		}
		return Collections.singletonMap("error", message);
	}
	


	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleError (IncompatibleAircraftDetailException e){
		String message = e.getMessage();
		if (message == null || message.trim().length() == 0) {
			message = "Aircraft properties are incorrect";
		}
		return Collections.singletonMap("error", message);
	}
	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public Map<String, Object> handleError (AirlineAlreadyExistException e){
		String message = e.getMessage();
		if (message == null || message.trim().length() == 0) {
			message = "Airline Already Exist";
		}
		return Collections.singletonMap("error", message);
	}

	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public Map<String, Object> handleError (DontHaveMoneyException e){
		String message = e.getMessage();
		if (message == null || message.trim().length() == 0) {
			message = "Dont Have Money";
		}
		return Collections.singletonMap("error", message);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public Map<String, Object> handleError (AircraftAlreadyExistException e){
		String message = e.getMessage();
		if (message == null || message.trim().length() == 0) {
			message = "Aircraft Already Exist";
		}
		return Collections.singletonMap("error", message);
	}

}
