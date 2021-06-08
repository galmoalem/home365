package home365.Error;

public class DestinationAlreadyExistException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1132191770973170708L;

	public DestinationAlreadyExistException() {
	}

	public DestinationAlreadyExistException(String message) {
		super(message);
	}

	public DestinationAlreadyExistException(Throwable cause) {
		super(cause);
	}

	public DestinationAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
