package com.company.equipment;

import com.company.PrimaryAttribute;

public class Item {
    public PrimaryAttribute getAttributes() {
        return attributes;
    }

    PrimaryAttribute attributes = new PrimaryAttribute(0,0,0);

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
