package com.company;

import com.company.character.Character;
import com.company.character.Mage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<String, Character> createdCharacters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create character by enetering the name");
        String characterName = scanner.next();

        createdCharacters.put(characterName,new Mage(characterName));

        System.out.println(createdCharacters.get(characterName).level);

        createdCharacters.get(characterName).levelUp();

        System.out.println(createdCharacters.get(characterName).level);

        System.out.println(createdCharacters.get(characterName).attributes.baseIntelligence);

    }
}
