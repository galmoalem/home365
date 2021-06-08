package home365.Error;

public class AirlineAlreadyExistException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5714081393570301001L;

	public AirlineAlreadyExistException() {
	}

	public AirlineAlreadyExistException(String message) {
		super(message);
	}

	public AirlineAlreadyExistException(Throwable cause) {
		super(cause);
	}

	public AirlineAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
