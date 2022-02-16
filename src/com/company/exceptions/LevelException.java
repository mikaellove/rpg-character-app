package com.company.exceptions;

/**
 * Thrown when a character is of too low level to equip a certain item.
 */
public class LevelException extends Exception {
    public LevelException() {
        super("Character Level Is Too Low To Equip This Item");
    }
}
