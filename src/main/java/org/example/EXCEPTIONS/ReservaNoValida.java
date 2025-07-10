package org.example.EXCEPTIONS;

public class ReservaNoValida extends RuntimeException {
    public ReservaNoValida(String message) {
        super(message);
    }
}
