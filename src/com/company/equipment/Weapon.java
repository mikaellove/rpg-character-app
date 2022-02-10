package com.company.equipment;

import com.company.PrimaryAttribute;

public class Weapon extends Item{
    WeaponType type;

    public Weapon(PrimaryAttribute attributes, String name, int level, Slot slot) {
        super(attributes, name, level, slot);
    }

}
