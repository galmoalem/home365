package home365.Error;

public class AircraftNotFoundException extends RuntimeException {

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4792636411839562234L;

	public AircraftNotFoundException() {
	}

	public AircraftNotFoundException(String message) {
		super(message);
	}

	public AircraftNotFoundException(Throwable cause) {
		super(cause);
	}

	public AircraftNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
