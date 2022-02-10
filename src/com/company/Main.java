package com.company;

import com.company.character.Character;
import com.company.character.Mage;
import com.company.equipment.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<String, Character> createdCharacters = new HashMap<>();
        Map<String, Weapon> createdWeapons = new HashMap<>();
        Map<String, Armor> createdArmor = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String[] names = {"hej", "då", "vad"};
        String[] armorNames = {"blue", "red", "white"};
        Slot[] armorTypes = {Slot.BODY,Slot.HEAD,Slot.LEGS};
        CreateArmor(armorNames,armorTypes,createdArmor);
        CreateWeapons(names,createdWeapons);
        System.out.println(createdWeapons.get(names[1]).type);
        System.out.println(createdArmor.get(armorNames[0]).slot);
    }

    private static void CreateWeapons(String[] names, Map<String,Weapon> createdWeapons)
    {
        for(int i = 0; i < names.length; i++)
        {
            Weapon wep = new Weapon(new PrimaryAttribute(randomInt(),randomInt(),randomInt()),names[i],randomInt(),Slot.WEAPON,randomInt(),randomDouble(),WeaponType.values()[new Random().nextInt(WeaponType.values().length)]);
            createdWeapons.put(names[i],wep);
        }
    }

    private static void CreateArmor(String[] names, Slot[] slot ,Map<String,Armor> createdArmor)
    {
        for(int i = 0; i < names.length; i++)
        {
            Armor armor = new Armor(new PrimaryAttribute(randomInt(),randomInt(),randomInt()),names[i],randomInt(),slot[i], ArmorType.values()[new Random().nextInt(ArmorType.values().length)]);
            createdArmor.put(names[i],armor);
        }
    }

    private static int randomInt()
    {
        Random random = new Random();
        return (int) ((Math.random()) * (20 - 1) + 1);
    }

    private static double randomDouble()
    {
        Random random = new Random();
        return (double) ((Math.random()) * (20 - 1) + 1);
    }
}
