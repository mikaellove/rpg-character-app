package com.company.character;

import com.company.equipment.ArmorType;
import com.company.equipment.Slot;
import com.company.equipment.Weapon;
import com.company.equipment.WeaponType;

public class Warrior extends Character{
    public final String characterClass = "Warrior";


    WeaponType[] equippableWeapons = {WeaponType.AXE,WeaponType.HAMMER,WeaponType.SWORD};
    ArmorType[] equippableArmor = {ArmorType.MAIL, ArmorType.PLATE};

    public Warrior(String name) {
        super(name);

        super.setCharacterClass(characterClass);
        super.equippableArmor = this.equippableArmor;
        super.equippableWeapons = this.equippableWeapons;

        attributes.baseStrength = 5;
        attributes.baseDexterity = 2;
        attributes.baseIntelligence = 1;

    }

    @Override
    public void levelUp() {
        level += 1;

        attributes.baseStrength += 3;
        attributes.baseDexterity += 2;
        attributes.baseIntelligence += 1;
    }

    @Override
    public int getCharacterDps() {
        Weapon weapon = equipedWeapon.get(Slot.WEAPON);
        if(weapon == null) return 0;

        double weaponDps = weapon.GetWeaponDPS();
        int castedDPS = (int)weaponDps * (1 + getTotalAttributes().baseStrength/100);
        return castedDPS;
    }
}
