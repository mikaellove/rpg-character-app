package com.company.character;

import com.company.PrimaryAttribute;

public abstract class Character {
    public String name;
    public int level;

    public PrimaryAttribute attributes = new PrimaryAttribute(0,0,0);
    public PrimaryAttribute totalAttributes;

    public Character(String name) {
        this.name = name;
        this.level = 1;
    }

    public abstract void levelUp();

}
