package com.backend.tourBooking.exception;

public class AuthenticationFailedException extends RuntimeException{

    public AuthenticationFailedException(String message){
        super(message);
    }

}
