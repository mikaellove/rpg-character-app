package com.company;

import com.company.character.*;
import com.company.character.Character;
import com.company.equipment.*;
import com.company.exceptions.InvalidOptionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Application is started from here.
 * Contains hashmap for the characters that have been created.
 * Contains hashmaps for holding the weapon and armor that has been created, as well as hashmaps that are used for picking a weapon from.
 * Contains methods for creating weapons and armor with random stats.
 * Contains methods for all the different menus, equipping armor/weapon, viewing stats and creating your character.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String activeCharacterName = "";

        Map<Integer, Weapon> weaponsToChooseFrom = new HashMap<>();
        Map<Integer, Armor> armorToChooseFrom = new HashMap<>();
        Map<String, Character> createdCharacters = new HashMap<>();
        Map<String, Weapon> createdWeapons = new HashMap<>();
        Map<String, Armor> createdArmor = new HashMap<>();

        String[] armorNames = {"Chest Armor", "Head Armor", "Leg Armor"};
        Slot[] armorSlots = {Slot.BODY,Slot.HEAD,Slot.LEGS};
        CreateArmor(armorNames,armorSlots,createdArmor);

        String[] weaponNames = {"The Blood Drop", "Slayer Of Goats", "The Okay Weapon"};
        CreateWeapons(weaponNames,createdWeapons);


        activeCharacterName = CreateCharacterMenu(scanner,createdCharacters);

        Character activeCharacter = createdCharacters.get(activeCharacterName);

        mainMenu(activeCharacter, weaponsToChooseFrom, armorToChooseFrom, createdCharacters, createdWeapons, createdArmor);
    }

    private static String CreateCharacterMenu(Scanner scanner, Map<String, Character> createdCharacters)
    {
        while (true)
        {
            String activeCharacterName = "";
            System.out.println("Input number to create character and choose class....");
            System.out.println("1: Mage");
            System.out.println("2: Warrior");
            System.out.println("3: Ranger");
            System.out.println("4: Rogue");

            System.out.println("Enter number: ");
            try {
                switch (scanner.nextInt()){
                    case 1:
                        System.out.println("Give character a name:");
                        activeCharacterName = scanner.next();
                        createdCharacters.put(activeCharacterName,new Mage(activeCharacterName));
                        return activeCharacterName;
                    case 2:
                        System.out.println("Give character a name:");
                        activeCharacterName = scanner.next();
                        createdCharacters.put(activeCharacterName, new Warrior(activeCharacterName));
                        return activeCharacterName;
                    case 3:
                        System.out.println("Give character a name:");
                        activeCharacterName = scanner.next();
                        createdCharacters.put(activeCharacterName, new Ranger(activeCharacterName));
                        return activeCharacterName;
                    case 4:
                        System.out.println("Give character a name:");
                        activeCharacterName = scanner.next();
                        createdCharacters.put(activeCharacterName, new Rogue(activeCharacterName));
                        return activeCharacterName;
                    default:
                        throw new InvalidOptionException();
                }
            }
            catch (Exception e) {
                System.out.println(e + ", Try Again....");
                scanner.nextLine();
                continue;
            }
        }
    }

    /**
     * The main menu of the application invokes all the submenus then uses recursion to go back to the main menu.
     * Throws an invalid option exception, catches it then displays it and takes the user back to the main menu to try again.
     * @param activeCharacter
     * @param weaponsToChooseFrom
     * @param armorToChooseFrom
     * @param createdCharacters
     * @param createdWeapons
     * @param createdArmor
     */
    private static void mainMenu(
            Character activeCharacter,
            Map<Integer, Weapon> weaponsToChooseFrom,
            Map<Integer, Armor> armorToChooseFrom,
            Map<String, Character> createdCharacters,
            Map<String, Weapon> createdWeapons,
            Map<String, Armor> createdArmor
    )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number to choose action....");
        System.out.println("1: Level Up Character.");
        System.out.println("2: Equip Weapon.");
        System.out.println("3: Equip Armor.");
        System.out.println("4: Display Character Stats.");
        try {
            switch(scanner.nextInt())
            {
                case 1:
                    activeCharacter.levelUp();
                    mainMenu(activeCharacter,weaponsToChooseFrom,armorToChooseFrom,createdCharacters,createdWeapons,createdArmor);
                    break;
                case 2:
                    equipWeaponMenu(scanner,activeCharacter,weaponsToChooseFrom,createdWeapons);
                    mainMenu(activeCharacter,weaponsToChooseFrom,armorToChooseFrom,createdCharacters,createdWeapons,createdArmor);
                    break;
                case 3:
                    equipArmorMenu(scanner,activeCharacter,armorToChooseFrom,createdArmor);
                    mainMenu(activeCharacter,weaponsToChooseFrom,armorToChooseFrom,createdCharacters,createdWeapons,createdArmor);
                    break;
                case 4:
                    displayCharacterStats(activeCharacter);
                    mainMenu(activeCharacter,weaponsToChooseFrom,armorToChooseFrom,createdCharacters,createdWeapons,createdArmor);
                    break;
                default:
                    throw new InvalidOptionException();
            }
        }
        catch (Exception e) {
            System.out.println(e + ", Try Again....");
            mainMenu(activeCharacter,weaponsToChooseFrom,armorToChooseFrom,createdCharacters,createdWeapons,createdArmor);
        }

    }

    private static void displayCharacterStats(Character activeCharacter)
    {
        System.out.println(activeCharacter.getCharacterClass());
        System.out.println("Character Name: " + activeCharacter.getName());
        System.out.println("Character Level: " + activeCharacter.getLevel());
        System.out.println("");
        System.out.println("Character Stats:");
        System.out.println("Strength: " + activeCharacter.getAttributes().getStrength());
        System.out.println("Dexterity: " + activeCharacter.getAttributes().getDexterity());
        System.out.println("Intelligence: " + activeCharacter.getAttributes().getIntelligence());
        System.out.println("DPS: " + activeCharacter.getCharacterDps());
        System.out.println("Press Enter To Continue....");
        try {
            System.in.read();
        }
        catch (Exception e) {}
    }

    private static void equipArmorMenu(Scanner scanner, Character activeCharacter, Map<Integer, Armor> armorToChooseFrom, Map<String, Armor> createdArmor)
    {
        System.out.println(activeCharacter.getName() + " " + activeCharacter.getCharacterClass() + " Level: " + activeCharacter.getLevel());
        int count = 0;
        for(Map.Entry<String,Armor> entry : createdArmor.entrySet())
        {
            count++;
            armorToChooseFrom.put(count,entry.getValue());
            System.out.println(count + ":" + entry.getKey() + " is of type " + entry.getValue().getType() + " and can be equiped at level " + entry.getValue().level);
        }

        System.out.println("Enter Number To Equip Weapon:");
        try {
            int chosenOption = scanner.nextInt();
            if(chosenOption > count) throw new InvalidOptionException();

            Armor chosenArmor = armorToChooseFrom.get(chosenOption);
            activeCharacter.equipArmor(chosenArmor);
        }
        catch (Exception e) {
            System.out.println(e + " Try Again....");
        }
    }

    private static void equipWeaponMenu(Scanner scanner, Character activeCharacter, Map<Integer, Weapon> weaponsToChooseFrom, Map<String, Weapon> createdWeapons)
    {
        System.out.println(activeCharacter.getName() + " " + activeCharacter.getCharacterClass() + " Level: " + activeCharacter.getLevel());
        int count = 0;
        for(Map.Entry<String,Weapon> entry : createdWeapons.entrySet())
        {
            count++;
            weaponsToChooseFrom.put(count,entry.getValue());
            System.out.println(count + ":" + entry.getKey() + " is of type " + entry.getValue().getType() + " and can be equiped at level " + entry.getValue().level);
        }

        System.out.println("Enter Number To Equip Weapon:");
        try {
            int chosenOption = scanner.nextInt();
            if(chosenOption > count) throw new InvalidOptionException();

            Weapon chosenWeapon = weaponsToChooseFrom.get(chosenOption);
            activeCharacter.equipWeapon(chosenWeapon);
        }
        catch (Exception e){
            System.out.println(e + " Try Again....");
        }
    }

    private static void CreateWeapons(String[] names, Map<String,Weapon> createdWeapons)
    {
        for(int i = 0; i < names.length; i++)
        {
            Weapon wep = new Weapon(names[i],randomInt(),randomInt(),randomDouble(),WeaponType.values()[new Random().nextInt(WeaponType.values().length)]);
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
