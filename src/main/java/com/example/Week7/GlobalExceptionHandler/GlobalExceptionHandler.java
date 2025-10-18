package com.example.Week7.GlobalExceptionHandler;

public class GlobalExceptionHandler {

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
