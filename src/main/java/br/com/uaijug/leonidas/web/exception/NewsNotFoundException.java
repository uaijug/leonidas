package br.com.uaijug.leonidas.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Noticias não encontrada.")
public class NewsNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public NewsNotFoundException() {
	}

	public NewsNotFoundException(String message) {
		super(message);
	}

	public NewsNotFoundException(Throwable cause) {
		super(cause);
	}

	public NewsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NewsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
