package com.poc.exception;

/**
 * @author Mitesh Parmar
 */
public class TaskServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    public TaskServiceException() {
        super();
    }

    public TaskServiceException(String errorMessage) {
        super(errorMessage);
    }

    public TaskServiceException(String errorMessage, Throwable t) {
        super(errorMessage, t);
    }

}
