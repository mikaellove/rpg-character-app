package com.company.character;

import com.company.equipment.ArmorType;
import com.company.equipment.Slot;
import com.company.equipment.Weapon;
import com.company.equipment.WeaponType;

public class Warrior extends Character{
    public final String characterClass = "Warrior";


    private final WeaponType[] equippableWeapons = {WeaponType.AXE,WeaponType.HAMMER,WeaponType.SWORD};
    private final ArmorType[] equippableArmor = {ArmorType.MAIL, ArmorType.PLATE};

    public Warrior(String name) {
        super(name);

        super.setCharacterClass(characterClass);
        super.equippableArmor = this.equippableArmor;
        super.equippableWeapons = this.equippableWeapons;

        super.attributes.setStrength(5);
        super.attributes.setDexterity(2);
        super.attributes.setIntelligence(1);
    }

    @Override
    public void levelUp() {
        level += 1;

        attributes.setStrength(attributes.getStrength() + 3);
        attributes.setDexterity(attributes.getDexterity() + 2);
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
