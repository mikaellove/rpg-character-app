package com.company.character;

import com.company.equipment.ArmorType;
import com.company.equipment.Slot;
import com.company.equipment.Weapon;
import com.company.equipment.WeaponType;

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
    public int getCharacterDps() {
        Weapon weapon = equipedWeapon.get(Slot.WEAPON);
        if(weapon == null) return 0;

        double weaponDps = weapon.GetWeaponDPS();
        int castedDPS = (int)weaponDps * (1 + getTotalAttributes().getDexterity()/100);
        return castedDPS;
    }
}
