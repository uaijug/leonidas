package br.com.uaijug.leonidas.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Evento não encontrada.")
public class EventNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public EventNotFoundException() {
	}

	public EventNotFoundException(String message) {
		super(message);
	}

	public EventNotFoundException(Throwable cause) {
		super(cause);
	}

	public EventNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EventNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
