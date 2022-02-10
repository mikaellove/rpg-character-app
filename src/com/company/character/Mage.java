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

    @Override
    public int getCharacterDps() {
        double weaponDps = equipedWeapon.get(Slot.WEAPON).GetWeaponDPS();
        int castedDPS = (int)weaponDps * (1 + getTotalAttributes().baseIntelligence/100);
        return castedDPS;
    }
}
