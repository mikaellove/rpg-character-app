package com.company.character;

import com.company.equipment.*;

/**
 * A child class of Character.java.
 * Contains string of specified class.
 * Holds which weapons and armor this class can use and passes them down in the constructor to the base class.
 */
public class Mage extends Character{
    public final String characterClass = "Mage";

    private final WeaponType[] equippableWeapons = {WeaponType.STAFF,WeaponType.WAND};
    private final ArmorType[] equippableArmor = {ArmorType.CLOTH};

    public Mage(String name) {
        super(name);

        super.setCharacterClass(characterClass);
        super.equippableArmor = this.equippableArmor;
        super.equippableWeapons = this.equippableWeapons;

        super.attributes.setStrength(1);
        super.attributes.setDexterity(1);
        super.attributes.setIntelligence(8);
    }

    @Override
    public void levelUp() {
        level += 1;

        attributes.setStrength(attributes.getStrength() + 1);
        attributes.setDexterity(attributes.getDexterity() + 1);
        attributes.setIntelligence(attributes.getIntelligence() + 5);
    }

    @Override
    public double getCharacterDps() {
        Weapon weapon = equipedWeapon.get(Slot.WEAPON);
        double weaponDps = 1;

        if(weapon != null){
            weaponDps = weapon.GetWeaponDPS();
        }

        double castedDPS = weaponDps * (1 + getTotalAttributes().getStrength()/100);
        return castedDPS;
    }
}
