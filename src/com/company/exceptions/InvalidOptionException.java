package com.company.exceptions;

public class InvalidOptionException extends Exception {
    public InvalidOptionException()
    {
        super("This Option Is Invalid");
    }
}
