package home365.Error;

public class DontHaveMoneyException  extends RuntimeException{

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8615846939778497966L;

	public DontHaveMoneyException() {
	}

	public DontHaveMoneyException(String message) {
		super(message);
	}

	public DontHaveMoneyException(Throwable cause) {
		super(cause);
	}

	public DontHaveMoneyException(String message, Throwable cause) {
		super(message, cause);
	}

}
