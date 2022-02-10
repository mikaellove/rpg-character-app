package com.company.character;

import com.company.equipment.*;

import java.util.logging.Logger;

public class Mage extends Character{
    WeaponType[] equippableWeapons = {WeaponType.STAFF,WeaponType.WAND};
    ArmorType[] equippableArmor = {ArmorType.CLOTH};

    public Mage(String name) {
        super(name);

        attributes.baseDexterity = 1;
        attributes.baseIntelligence = 8;
        attributes.baseStrength = 1;
    }

    @Override
    public void levelUp() {
        level += 1;

        attributes.baseDexterity += 1;
        attributes.baseStrength += 1;
        attributes.baseIntelligence += 5;
    }

    public void equipWeapon(Weapon weapon)
    {
        super.equipWeapon(weapon,equippableWeapons);
    }

    public void unEquip(Weapon weapon){
        super.unEquip(weapon);
    }
}
