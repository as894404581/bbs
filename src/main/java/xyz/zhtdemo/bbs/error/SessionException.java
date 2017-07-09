package xyz.zhtdemo.bbs.error;

public class SessionException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public SessionException() {
		
	}

	public SessionException(String message) {
		super(message);
		
	}

	public SessionException(Throwable cause) {
		super(cause);
		
	}

	public SessionException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public SessionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
