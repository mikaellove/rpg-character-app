package com.company.equipment;

import com.company.PrimaryAttribute;

public class Armor extends Item{
    ArmorType type;

    public Armor(PrimaryAttribute attributes, String name, int level, Slot slot) {
        super(attributes, name, level, slot);
    }
}
