package com.company.character;

import com.company.equipment.*;

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
    public int getCharacterDps() {
        Weapon weapon = equipedWeapon.get(Slot.WEAPON);
        if(weapon == null) return 0;

        double weaponDps = weapon.GetWeaponDPS();
        int castedDPS = (int)weaponDps * (1 + getTotalAttributes().getIntelligence()/100);
        return castedDPS;
    }
}
