package br.com.uaijug.leonidas.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Noticias não encontrada.")
public class SessionNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public SessionNotFoundException() {
	}

	public SessionNotFoundException(String message) {
		super(message);
	}

	public SessionNotFoundException(Throwable cause) {
		super(cause);
	}

	public SessionNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SessionNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
