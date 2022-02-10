package com.company.character;

import com.company.equipment.ArmorType;
import com.company.equipment.WeaponType;

public class Ranger extends Character{
    WeaponType[] equippableWeapons = {WeaponType.BOW};
    ArmorType[] equippableArmor = {ArmorType.LEATHER,ArmorType.MAIL};

    public Ranger(String name) {
        super(name);

        super.equippableArmor = this.equippableArmor;
        super.equippableWeapons = this.equippableWeapons;

        attributes.baseStrength = 1;
        attributes.baseDexterity = 7;
        attributes.baseIntelligence = 1;

    }

    @Override
    public void levelUp() {
        level += 1;

        attributes.baseStrength += 1;
        attributes.baseDexterity += 5;
        attributes.baseIntelligence += 1;
    }
}
