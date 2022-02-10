package com.company.character;

import com.company.PrimaryAttribute;
import com.company.equipment.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Character {
    public String name;
    public int level;

    public PrimaryAttribute attributes = new PrimaryAttribute(0,0,0);

    private Map<Slot, Armor> equipedArmor = new HashMap<>();
    protected Map<Slot, Weapon> equipedWeapon = new HashMap<>();
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
                equipedWeapon.put(weapon.slot,weapon);
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
                equipedArmor.put(armor.slot,armor);
                return;
            }
        }

        // throw cant quip exception
    }

    public abstract int getCharacterDps();

    public PrimaryAttribute getTotalAttributes()
    {
        PrimaryAttribute totalAttributes = new PrimaryAttribute(0,0,0);
        equipedArmor.forEach((key,value) -> {
            totalAttributes.baseIntelligence += value.getAttributes().baseIntelligence;
            totalAttributes.baseStrength += value.getAttributes().baseStrength;
            totalAttributes.baseDexterity += value.getAttributes().baseDexterity;
        });

        equipedWeapon.forEach((key,value) -> {
            totalAttributes.baseIntelligence += value.getAttributes().baseIntelligence;
            totalAttributes.baseDexterity += value.getAttributes().baseDexterity;
            totalAttributes.baseStrength += value.getAttributes().baseStrength;
        });

        return totalAttributes;
    }
}
