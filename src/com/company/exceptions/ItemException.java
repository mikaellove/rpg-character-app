package com.company.exceptions;

/**
 * Thrown when a character class tries to equip an item which is not eligible for their class.
 */
public class ItemException extends Exception {
    public ItemException() {
        super("Character Class Cant Equip This Item");
    }
}
