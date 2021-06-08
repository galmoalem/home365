package home365.Error;

public class AircraftAlreadyExistException extends RuntimeException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5448526242373535574L;

	public AircraftAlreadyExistException() {
	}

	public AircraftAlreadyExistException(String message) {
		super(message);
	}

	public AircraftAlreadyExistException(Throwable cause) {
		super(cause);
	}

	public AircraftAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
