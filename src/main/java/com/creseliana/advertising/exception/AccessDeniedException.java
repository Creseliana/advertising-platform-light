package com.creseliana.advertising.exception;

/**
 * @author Valeria Sterzhanova
 */
public class AccessDeniedException extends ApplicationRuntimeException {

    private static final long serialVersionUID = 137746293506602108L;

    public AccessDeniedException() {
    }

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }
}
