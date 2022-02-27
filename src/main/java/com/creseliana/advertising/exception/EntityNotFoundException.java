package com.creseliana.advertising.exception;

/**
 * @author Valeria Sterzhanova
 */
public class EntityNotFoundException extends ApplicationRuntimeException {

    private static final long serialVersionUID = 304592046731580083L;

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
