package br.com.uaijug.leonidas.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Instituição não encontrada.")
public class InstituitionNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public InstituitionNotFoundException() {
	}

	public InstituitionNotFoundException(String message) {
		super(message);
	}

	public InstituitionNotFoundException(Throwable cause) {
		super(cause);
	}

	public InstituitionNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public InstituitionNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
