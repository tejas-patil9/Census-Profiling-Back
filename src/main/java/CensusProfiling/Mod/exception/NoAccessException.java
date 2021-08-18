package CensusProfiling.Mod.exception;

public class NoAccessException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoAccessException() {
	}

	public NoAccessException(String msg) {
		super(msg);
	}
}
