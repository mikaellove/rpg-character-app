package com.company.character;

import com.company.equipment.ArmorType;
import com.company.equipment.WeaponType;

public class Rogue extends Character {
    WeaponType[] equippableWeapons = {WeaponType.STAFF,WeaponType.WAND};
    ArmorType[] equippableArmor = {ArmorType.CLOTH};

    public Rogue(String name) {
        super(name);

        super.equippableArmor = this.equippableArmor;
        super.equippableWeapons = this.equippableWeapons;

        attributes.baseStrength = 2;
        attributes.baseDexterity = 6;
        attributes.baseIntelligence = 1;

    }

    @Override
    public void levelUp() {
        level += 1;

        attributes.baseStrength += 1;
        attributes.baseDexterity += 4;
        attributes.baseIntelligence += 1;
    }
}
