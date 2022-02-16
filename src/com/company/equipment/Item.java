package com.company.equipment;

import com.company.PrimaryAttribute;

/**
 * Base class for armor and weapon classes
 */
public class Item {

    public String name;
    public int level;

    public Slot slot;

    public Item(String name, int level, Slot slot) {
        this.name = name;
        this.level = level;
        this.slot = slot;
    }


}
