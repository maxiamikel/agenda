package com.maxi.agenda.services.exceptions;

public class ObjectClassDuplicateException extends RuntimeException {

    public ObjectClassDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectClassDuplicateException(String message) {
        super(message);
    }

}
