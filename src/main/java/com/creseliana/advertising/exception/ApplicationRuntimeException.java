package com.creseliana.advertising.exception;

/**
 * @author Valeria Sterzhanova
 */
public class ApplicationRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 7775911648610470462L;

    public ApplicationRuntimeException() {
    }

    public ApplicationRuntimeException(String message) {
        super(message);
    }

    public ApplicationRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
