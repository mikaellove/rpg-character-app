package com.company.character;

import com.company.equipment.ArmorType;
import com.company.equipment.Slot;
import com.company.equipment.Weapon;
import com.company.equipment.WeaponType;

public class Rogue extends Character {
    public final String characterClass = "Rogue";


    private final WeaponType[] equippableWeapons = {WeaponType.DAGGER,WeaponType.SWORD};
    private final ArmorType[] equippableArmor = {ArmorType.MAIL,ArmorType.LEATHER};

    public Rogue(String name) {
        super(name);

        super.setCharacterClass(characterClass);
        super.equippableArmor = this.equippableArmor;
        super.equippableWeapons = this.equippableWeapons;

        super.attributes.setStrength(2);
        super.attributes.setDexterity(6);
        super.attributes.setIntelligence(1);
    }

    @Override
    public void levelUp() {
        level += 1;

        attributes.setStrength(attributes.getStrength() + 1);
        attributes.setDexterity(attributes.getDexterity() + 4);
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
