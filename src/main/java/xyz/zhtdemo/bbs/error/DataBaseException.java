package xyz.zhtdemo.bbs.error;

public class DataBaseException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public DataBaseException() {
		
	}

	public DataBaseException(String message) {
		super(message);
		
	}

	public DataBaseException(Throwable cause) {
		super(cause);
		
	}

	public DataBaseException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DataBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
