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
        Scanner scanner = new Scanner(System.in);
        String activeCharacter = "";

        Map<Integer, Weapon> weaponsToChooseFrom = new HashMap<>();
        Map<String, Character> createdCharacters = new HashMap<>();
        Map<String, Weapon> createdWeapons = new HashMap<>();
        Map<String, Armor> createdArmor = new HashMap<>();

        String[] armorNames = {"Chest Armor", "Head Armor", "Leg Armor"};
        Slot[] armorSlots = {Slot.BODY,Slot.HEAD,Slot.LEGS};
        CreateArmor(armorNames,armorSlots,createdArmor);

        String[] weaponNames = {"The Blood Drop", "Slayer Of Goats", "The Okay Weapon"};
        CreateWeapons(weaponNames,createdWeapons);

        System.out.println("Input number to create character....");
        System.out.println("1: Mage");
        System.out.println("Enter number: ");

        switch (scanner.nextInt()){
            case 1:
                System.out.println("Give character a name:");
                String name = scanner.next();
                createdCharacters.put(name,new Mage(name));
                activeCharacter = name;
        }

        System.out.println("Input number to choose action....");
        System.out.println("1: Level up character.");
        System.out.println("2: Equip Weapon.");
        System.out.println("3: Equip Armor.");
        switch(scanner.nextInt())
        {
            case 1:
                createdCharacters.get(activeCharacter).levelUp();
                System.out.println(createdCharacters.get(activeCharacter).level);
                break;
            case 2:
                int count = 0;
                for(Map.Entry<String,Weapon> entry : createdWeapons.entrySet())
                {
                    count++;
                    weaponsToChooseFrom.put(count,entry.getValue());
                    System.out.println(count + ":" + entry.getKey() + " is of type " + entry.getValue().type + " and can be equiped at level " + entry.getValue().level);
                }
        }

        System.out.println("Enter number to choose weapon:");
        createdCharacters.get(activeCharacter).equipWeapon(weaponsToChooseFrom.get(scanner.nextInt()));
        //createdCharacters.get(activeCharacter).getEquipment().size();
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
