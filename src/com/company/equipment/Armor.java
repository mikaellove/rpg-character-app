package com.company.equipment;

import com.company.PrimaryAttribute;

public class Armor extends Item{
    public ArmorType type;

    public Armor(PrimaryAttribute attributes, String name, int level, Slot slot, ArmorType type) {
        super(attributes, name, level, slot);

        this.type = type;
    }
}
