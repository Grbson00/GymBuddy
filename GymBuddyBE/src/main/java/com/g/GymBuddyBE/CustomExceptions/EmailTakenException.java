package com.g.GymBuddyBE.CustomExceptions;

public class EmailTakenException extends RuntimeException{
    public EmailTakenException(String message) {
        super(message);
    }
}
