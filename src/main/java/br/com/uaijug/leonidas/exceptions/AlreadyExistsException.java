package br.com.uaijug.leonidas.exceptions;

public class AlreadyExistsException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public AlreadyExistsException(final String message) {
        super(message);
    }

}
