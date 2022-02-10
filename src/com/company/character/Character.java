package com.company.character;

import com.company.PrimaryAttribute;
import com.company.equipment.Item;
import com.company.equipment.Slot;
import com.company.equipment.Weapon;
import com.company.equipment.WeaponType;

import java.util.HashMap;
import java.util.Map;

public abstract class Character {
    public String name;
    protected int level;

    public PrimaryAttribute attributes = new PrimaryAttribute(0,0,0);
    public PrimaryAttribute totalAttributes;

    private Map<Slot, Item> equipment = new HashMap<>();

    public Character(String name) {
        this.name = name;
        this.level = 1;
    }

    public abstract void levelUp();

    protected void equipWeapon(Weapon weapon, WeaponType[] equippableWeapons)
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

    protected void unEquip(Item item){
        equipment.remove(item.slot);
    }

    public Map<Slot, Item> getEquipment(){
        return equipment;
    }
}
