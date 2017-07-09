package xyz.zhtdemo.bbs.error;

public class LengthOutException extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public LengthOutException() {
		super();
	}

	public LengthOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LengthOutException(String message, Throwable cause) {
		super(message, cause);
	}

	public LengthOutException(String message) {
		super(message);
	}

	public LengthOutException(Throwable cause) {
		super(cause);
	}
	

}
