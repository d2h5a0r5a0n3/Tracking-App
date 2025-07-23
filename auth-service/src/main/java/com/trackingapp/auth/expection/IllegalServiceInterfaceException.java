package com.trackingapp.auth.expection;

public class IllegalServiceInterfaceException extends RuntimeException{
    public IllegalServiceInterfaceException(String message){
        super(message);
    }
}
