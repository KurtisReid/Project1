package dev.reid.exceptions;

public class NoAppUserFoundException extends RuntimeException{
    public NoAppUserFoundException(String message)
    {
        super(message);
    }
}
