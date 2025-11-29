package com.murat.backend.exception;


public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
