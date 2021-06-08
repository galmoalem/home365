package home365.Error;

public class IncompatibleAirlineDetailException extends RuntimeException {

	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7388199697899329096L;

	public IncompatibleAirlineDetailException() {
	}

	public IncompatibleAirlineDetailException(String message) {
		super(message);
	}

	public IncompatibleAirlineDetailException(Throwable cause) {
		super(cause);
	}

	public IncompatibleAirlineDetailException(String message, Throwable cause) {
		super(message, cause);
	}

}
