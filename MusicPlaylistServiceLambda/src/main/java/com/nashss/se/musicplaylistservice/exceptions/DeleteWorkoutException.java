package com.nashss.se.musicplaylistservice.exceptions;

public class DeleteWorkoutException extends InvalidAttributeException{

    private static final long serialVersionUID = 4889523600322674674L;

    public DeleteWorkoutException() {
        super();
    }

    public DeleteWorkoutException(String message) {
        super(message);
    }

    public DeleteWorkoutException(Throwable cause) {
        super(cause);
    }

    public DeleteWorkoutException(String message, Throwable cause) {
        super(message, cause);
    }

}
