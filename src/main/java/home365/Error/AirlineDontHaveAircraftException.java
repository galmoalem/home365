package home365.Error;

public class AirlineDontHaveAircraftException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 929427297080739786L;

	
	

	public AirlineDontHaveAircraftException() {
	}

	public AirlineDontHaveAircraftException(String message) {
		super(message);
	}

	public AirlineDontHaveAircraftException(Throwable cause) {
		super(cause);
	}

	public AirlineDontHaveAircraftException(String message, Throwable cause) {
		super(message, cause);
	}
}
