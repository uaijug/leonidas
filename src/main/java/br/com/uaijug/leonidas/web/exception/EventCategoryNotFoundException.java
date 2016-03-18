package br.com.uaijug.leonidas.web.exception;

public class EventCategoryNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public EventCategoryNotFoundException() {
		super();
	}

	public EventCategoryNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EventCategoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EventCategoryNotFoundException(String message) {
		super(message);
	}

	public EventCategoryNotFoundException(Throwable cause) {
		super(cause);
	}

}
