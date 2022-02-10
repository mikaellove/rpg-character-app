package com.company.equipment;

import com.company.PrimaryAttribute;

public class Armor extends Item{
    ArmorType type;

    public Armor(PrimaryAttribute attributes, String name, int level, Slot slot, ArmorType type) {
        super(attributes, name, level, slot);

        type = type;
    }
}
