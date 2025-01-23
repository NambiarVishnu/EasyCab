package com.example.EasyCab.exception;

public class CabUnavailableException extends RuntimeException{
    public CabUnavailableException(String message){
        super(message);
    }
}
