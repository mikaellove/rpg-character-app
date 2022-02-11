package com.company.character;

import com.company.equipment.ArmorType;
import com.company.equipment.Slot;
import com.company.equipment.Weapon;
import com.company.equipment.WeaponType;

public class Rogue extends Character {
    public final String characterClass = "Rogue";


    WeaponType[] equippableWeapons = {WeaponType.DAGGER,WeaponType.SWORD};
    ArmorType[] equippableArmor = {ArmorType.MAIL,ArmorType.LEATHER};

    public Rogue(String name) {
        super(name);

        super.setCharacterClass(characterClass);
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

    @Override
    public int getCharacterDps() {
        Weapon weapon = equipedWeapon.get(Slot.WEAPON);
        if(weapon == null) return 0;

        double weaponDps = weapon.GetWeaponDPS();
        int castedDPS = (int)weaponDps * (1 + getTotalAttributes().baseDexterity/100);
        return castedDPS;
    }
}
