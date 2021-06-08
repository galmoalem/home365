package home365.Error;

public class AirlineNotFoundException extends RuntimeException {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 370969746710358011L;

	public AirlineNotFoundException() {
	}

	public AirlineNotFoundException(String message) {
		super(message);
	}

	public AirlineNotFoundException(Throwable cause) {
		super(cause);
	}

	public AirlineNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	
}
