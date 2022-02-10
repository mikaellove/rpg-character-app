package com.company.equipment;

import com.company.PrimaryAttribute;

public class Item {
    PrimaryAttribute attributes = new PrimaryAttribute();

    public String name;
    public int level;

    public Slot slot;

    public Item(PrimaryAttribute attributes, String name, int level, Slot slot) {
        this.attributes = attributes;
        this.name = name;
        this.level = level;
        this.slot = slot;
    }
}
