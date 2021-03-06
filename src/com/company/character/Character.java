package com.company.character;

import com.company.PrimaryAttribute;
import com.company.equipment.*;
import com.company.exceptions.ItemException;
import com.company.exceptions.LevelException;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all the character classes, Mage, Rogue, Ranger, Warrior.
 * Contains the Armor and weapons that are currently equiped and the armor and weapons that can be equiped by a specific class, these are set by the derived classes in its constructor.
 * Contains the attributes of a character as well as the level.
 * Holds methods for equipping armor and weapons, throws exceptions if the character is not eligible for the item.
 */
public abstract class Character {

    private String name;

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

    public abstract double getCharacterDps();

    public abstract void levelUp();

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public PrimaryAttribute getAttributes() {
        return attributes;
    }

    public boolean equipWeapon(Weapon weapon) throws LevelException, ItemException
    {
        if(levelCheck(weapon)) return false;

        for(int i = 0; i < equippableWeapons.length; i++)
        {
            if(weapon.getType() == equippableWeapons[i])
            {
                equipedWeapon.put(weapon.slot,weapon);
                return true;
            }
        }

        throw new ItemException();
    }

    public boolean equipArmor(Armor armor) throws LevelException, ItemException
    {
        if(levelCheck(armor)) return false;

        for(int i = 0; i < equippableArmor.length; i++)
        {
            if(armor.getType() == equippableArmor[i])
            {
                equipedArmor.put(armor.slot,armor);
                return true;
            }
        }

        throw new ItemException();
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

    private boolean levelCheck(Item item) throws LevelException{

            if(item.level > level)
            {
                throw new LevelException();
            }
            return false;
    }


}
