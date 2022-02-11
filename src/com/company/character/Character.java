package com.company.character;

import com.company.PrimaryAttribute;
import com.company.equipment.*;
import com.company.exceptions.ItemException;
import com.company.exceptions.LevelException;

import java.util.HashMap;
import java.util.Map;

public abstract class Character {
    public String getName() {
        return name;
    }

    private String name;

    public int getLevel() {
        return level;
    }

    protected int level;

    private String characterClass = "";

    protected PrimaryAttribute attributes = new PrimaryAttribute(0,0,0);

    private Map<Slot, Armor> equipedArmor = new HashMap<>();
    protected Map<Slot, Weapon> equipedWeapon = new HashMap<>();

    protected ArmorType[] equippableArmor;
    protected WeaponType[] equippableWeapons;

    public Character(String name) {
        this.name = name;
        this.level = 1;
    }

    public abstract int getCharacterDps();

    public abstract void levelUp();

    public PrimaryAttribute getAttributes() {
        return attributes;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

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


    public PrimaryAttribute getTotalAttributes()
    {
        int intelligence = 0;
        int dexterity = 0;
        int strength = 0;
        for(Armor armor : equipedArmor.values())
        {
            intelligence += armor.getAttributes().getIntelligence();
            dexterity += armor.getAttributes().getDexterity();
            strength += armor.getAttributes().getStrength();
        }

        intelligence += attributes.getIntelligence();
        dexterity += attributes.getDexterity();
        strength += attributes.getStrength();

        return new PrimaryAttribute(strength,dexterity,intelligence);
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
}
