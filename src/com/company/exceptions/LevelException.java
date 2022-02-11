package com.company.exceptions;

public class LevelException extends Exception {
    public LevelException() {
        super("Character Level Is Too Low To Equip This Item");
    }
}
