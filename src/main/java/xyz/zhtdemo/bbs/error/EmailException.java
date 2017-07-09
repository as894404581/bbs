package xyz.zhtdemo.bbs.error;

public class EmailException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public EmailException() {
		
	}

	public EmailException(String message) {
		super(message);
		
	}

	public EmailException(Throwable cause) {
		super(cause);
		
	}

	public EmailException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public EmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
