package com.company.exceptions;

/**
 * Thrown when an invalid option is chosen in either of the menus.
 */
public class InvalidOptionException extends Exception {
    public InvalidOptionException()
    {
        super("This Option Is Invalid");
    }
}
