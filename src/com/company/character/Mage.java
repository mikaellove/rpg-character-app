package com.company.character;

import com.company.equipment.*;

public class Mage extends Character{
    WeaponType[] equippableWeapons = {WeaponType.STAFF,WeaponType.WAND};
    ArmorType[] equippableArmor = {ArmorType.CLOTH};

    public Mage(String name) {
        super(name);

        super.equippableArmor = this.equippableArmor;
        super.equippableWeapons = this.equippableWeapons;

        attributes.baseStrength = 1;
        attributes.baseDexterity = 1;
        attributes.baseIntelligence = 8;

    }

    @Override
    public void levelUp() {
        level += 1;

        attributes.baseStrength += 1;
        attributes.baseDexterity += 1;
        attributes.baseIntelligence += 5;
    }
}
