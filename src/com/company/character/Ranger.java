package com.company.character;

import com.company.equipment.ArmorType;
import com.company.equipment.Slot;
import com.company.equipment.Weapon;
import com.company.equipment.WeaponType;
/**
 * A child class of Character.java.
 * Contains string of specified class.
 * Holds which weapons and armor this class can use and passes them down in the constructor to the base class.
 */
public class Ranger extends Character{
    public final String characterClass = "Ranger";


    private final WeaponType[] equippableWeapons = {WeaponType.BOW};
    private final ArmorType[] equippableArmor = {ArmorType.LEATHER,ArmorType.MAIL};

    public Ranger(String name) {
        super(name);

        super.setCharacterClass(characterClass);
        super.equippableArmor = this.equippableArmor;
        super.equippableWeapons = this.equippableWeapons;

        super.attributes.setStrength(1);
        super.attributes.setDexterity(7);
        super.attributes.setIntelligence(1);
    }

    @Override
    public void levelUp() {
        level += 1;

        attributes.setStrength(attributes.getStrength() + 1);
        attributes.setDexterity(attributes.getDexterity() + 5);
        attributes.setIntelligence(attributes.getIntelligence() + 1);
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
