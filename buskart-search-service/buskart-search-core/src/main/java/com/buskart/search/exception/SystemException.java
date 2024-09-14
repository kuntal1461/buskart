package com.buskart.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Exception thrown when a system-level error occurs.
 * 
 * This could be due to issues like database connectivity problems,
 * external service failures, or other unexpected system issues.
 * 
 * Author: Kuntal
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SystemException extends Exception {

    /**
     * Constructs a new SystemException with the specified detail message.
     *
     * @param message The detail message.
     * 
     * Author: Kuntal
     */
    public SystemException(String message) {
        super(message);
    }

    /**
     * Constructs a new SystemException with the specified detail message and cause.
     *
     * @param message The detail message.
     * @param cause   The cause of the exception.
     * 
     * Author: Kuntal
     */
    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
