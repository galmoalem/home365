package home365.Error;

public class IncompatibleAircraftDetailException extends RuntimeException{

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3060951637115636682L;

	public IncompatibleAircraftDetailException() {
	}

	public IncompatibleAircraftDetailException(String message) {
		super(message);
	}

	public IncompatibleAircraftDetailException(Throwable cause) {
		super(cause);
	}

	public IncompatibleAircraftDetailException(String message, Throwable cause) {
		super(message, cause);
	}

}
