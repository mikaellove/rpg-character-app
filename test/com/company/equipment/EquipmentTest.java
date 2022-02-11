package com.company.equipment;

import com.company.character.Character;
import com.company.character.Mage;
import com.company.character.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {
    @Test
    public void TestCharacterEquippingHighLevelWeapon_ShouldThrowException()
    {
        Character character = new Warrior("Love");
        Weapon axe = new Weapon("axe",2,10,1.5,WeaponType.AXE);
    }
}