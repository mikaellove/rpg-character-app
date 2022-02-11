package com.company.character;

import com.company.PrimaryAttribute;
import com.company.equipment.*;
import com.company.exceptions.ItemException;
import com.company.exceptions.LevelException;

import java.util.HashMap;
import java.util.Map;

public abstract class Character {
    public String characterClass = "";

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

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
        if(levelCheck(weapon)) return;

        for(int i = 0; i < equippableWeapons.length; i++)
        {
            if(weapon.getType() == equippableWeapons[i])
            {
                equipedWeapon.put(weapon.slot,weapon);
                return;
            }
        }

        throwItemException();
    }

    public void equipArmor(Armor armor)
    {
        if(levelCheck(armor)) return;

        for(int i = 0; i < equippableArmor.length; i++)
        {
            if(armor.getType() == equippableArmor[i])
            {
                equipedArmor.put(armor.slot,armor);
                return;
            }
        }

        throwItemException();
    }

    private void throwItemException()
    {
        try {
            throw new ItemException();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private boolean levelCheck(Item item){
        try {
            if(item.level > level)
            {
                throw new LevelException();
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return true;
        }

        return false;
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
