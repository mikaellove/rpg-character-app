package com.company.equipment;

import com.company.PrimaryAttribute;
import com.company.character.Character;
import com.company.character.Mage;
import com.company.character.Warrior;
import com.company.exceptions.ItemException;
import com.company.exceptions.LevelException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {
    Character character;

    @BeforeEach
    public void initEach(){
        character = new Warrior("Love");
    }

    @Test
    public void TestCharacterEquippingHighLevelWeapon_ShouldThrowException()
    {
        Weapon axe = new Weapon("axe",2,10,1.5,WeaponType.AXE);

        LevelException level = assertThrows(LevelException.class, () -> {
            character.equipWeapon(axe);
        }, "exception not thrown");
    }
    @Test
    public void TestCharacterEquippingHighLevelArmor_ShouldThrowException(){
        Armor plateBodyArmor = new Armor(new PrimaryAttribute(0,0,0),"Body Armor",2,Slot.BODY,ArmorType.PLATE);

        LevelException levelException = assertThrows(LevelException.class, () -> {
            character.equipArmor(plateBodyArmor);
        }, "exception not thrown");
    }

    @Test
    public void TestCharacterEquippingWrongWeaponType_ShouldThrowException(){
        Weapon bow = new Weapon("The Bow",1,10,1.5,WeaponType.BOW);

        ItemException itemException = assertThrows(ItemException.class, () -> {
            character.equipWeapon(bow);
        }, "Exception not thrown");
    }

    @Test
    public void TestCharacterEquippingWrongArmorType_ShouldThrowException(){
        Armor clothArmor = new Armor(new PrimaryAttribute(0,0,0),"Cloth Armor",1,Slot.BODY,ArmorType.CLOTH);

        ItemException itemException = assertThrows(ItemException.class, () -> {
            character.equipArmor(clothArmor);
        }, "Exception not thrown");
    }

    @Test
    public void TestEquipValidWeapon(){
        Weapon sword =  new Weapon("Axe",1,1,1,WeaponType.SWORD);

        boolean weaponIsValid = false;
        try {
            weaponIsValid = character.equipWeapon(sword);
        }
       catch (Exception e){}

        assertEquals(true, weaponIsValid);
    }

    @Test
    public void TestEquipValidArmor(){
        Armor armorPiece = new Armor(new PrimaryAttribute(0,0,0),"The Armor Piece",1,Slot.HEAD,ArmorType.PLATE);

        boolean armorIsValid = false;
        try {
            armorIsValid = character.equipArmor(armorPiece);
        }
        catch (Exception e){}

        assertEquals(true, armorIsValid);
    }

    @Test
    public void TestCalculateTotalPrimaryAttribute()
    {
        Armor armor = new Armor(new PrimaryAttribute(2,2,2),"The Armor",2,Slot.HEAD,ArmorType.MAIL);

        character.levelUp();

        try {
            character.equipArmor(armor);
        }
        catch (Exception e){}

        int totalPrimaryAttribute = 10;

        assertEquals(totalPrimaryAttribute,character.getTotalAttributes().getStrength());
    }

    @Test
    public void TestCalculateDPSWithNoWeaponEquiped(){
        double expectedDPS = 1*(1 + (5/100));

        double characterDPS = character.getCharacterDps();
        assertEquals(expectedDPS, characterDPS);
    }

    @Test
    public void TestCalculateDPSWithWeaponEquiped(){
        Weapon weapon = new Weapon("The Weapon",1,7,1.1,WeaponType.AXE);

        try {
            character.equipWeapon(weapon);
        }
        catch (Exception e) {}

        double expectedDPS = (7 * 1.1)*(1 + (5 / 100));

        double characterDPS = character.getCharacterDps();
        assertEquals(expectedDPS, characterDPS);
    }

    @Test
    public void TestCalculateDPSWithWeaponAndArmorEquiped(){
        Weapon weapon = new Weapon("The Weapon",1,7,1.1,WeaponType.AXE);
        Armor armor = new Armor(new PrimaryAttribute(1,1,1),"The Armor",1,Slot.HEAD,ArmorType.PLATE);

        try {
            character.equipWeapon(weapon);
            character.equipArmor(armor);
        }
        catch (Exception e) {}

        double expectedDPS = (7 * 1.1)*(1 + ((5 + 1) / 100));

        double characterDPS = character.getCharacterDps();
        assertEquals(expectedDPS, characterDPS);
    }
}