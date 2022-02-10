package com.company.character;

import com.company.PrimaryAttribute;
import com.company.equipment.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Character {
    public String name;
    public int level;

    public PrimaryAttribute attributes = new PrimaryAttribute(0,0,0);
    public PrimaryAttribute totalAttributes;

    private Map<Slot, Item> equipment = new HashMap<>();
    protected ArmorType[] equippableArmor;
    WeaponType[] equippableWeapons;

    public Character(String name) {
        this.name = name;
        this.level = 1;
    }

    public abstract void levelUp();

    public void equipWeapon(Weapon weapon)
    {
        if(weapon.level > level)
        {
            // Throw level exception
            return;
        }


        for(int i = 0; i < equippableWeapons.length; i++)
        {
            if(weapon.type == equippableWeapons[i])
            {
                equipment.put(weapon.slot,weapon);
                return;
            }
        }

        // throw can't equip exception
    }

    public void equipArmor(Armor armor)
    {
        if(armor.level > level)
        {
            // Throw level exception
            return;
        }

        for(int i = 0; i < equippableArmor.length; i++)
        {
            if(armor.type == equippableArmor[i])
            {
                equipment.put(armor.slot,armor);
                return;
            }
        }

        // throw cant quip exception
    }

    public Map<Slot, Item> getEquipment(){
        return equipment;
    }
}
