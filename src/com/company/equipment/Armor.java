package com.company.equipment;

import com.company.PrimaryAttribute;

public class Armor extends Item{
    private ArmorType type;

    public PrimaryAttribute getAttributes() {
        return attributes;
    }

    private PrimaryAttribute attributes = new PrimaryAttribute(0,0,0);

    public Armor(PrimaryAttribute attributes, String name, int level, Slot slot, ArmorType type) {
        super(name, level, slot);

        this.attributes = attributes;
        this.type = type;
    }

    public ArmorType getType() {
        return type;
    }
}
