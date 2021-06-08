package home365.Error;

public class DestinationNotFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1369812241353880040L;

	public DestinationNotFoundException() {
	}

	public DestinationNotFoundException(String message) {
		super(message);
	}

	public DestinationNotFoundException(Throwable cause) {
		super(cause);
	}

	public DestinationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
