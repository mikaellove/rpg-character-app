package com.company.character;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    @Test
    public void characterShouldBeLevelOneWhenCreated()
    {
        Character character = new Mage("Love");
        int level = character.getLevel();
        Assertions.assertEquals(1,level);
    }
    @Test
    public void shouldLevelUp()
    {
        Character character = new Mage("Love");
        character.levelUp();
        int level = character.getLevel();
        Assertions.assertEquals(2,level);
    }
    @Test
    public void mageShouldHaveDefaultAttributesAtLevelOne()
    {
        Character character = new Mage("Love");
        int strength = character.getAttributes().getStrength();
        int dexterity = character.getAttributes().getDexterity();
        int intelligence = character.getAttributes().getIntelligence();
        Assertions.assertEquals(1,strength);
        Assertions.assertEquals(1,dexterity);
        Assertions.assertEquals(8,intelligence);
    }
    @Test
    public void warriorShouldHaveDefaultAttributesAtLevelOne()
    {
        Character character = new Warrior("Love");
        int strength = character.getAttributes().getStrength();
        int dexterity = character.getAttributes().getDexterity();
        int intelligence = character.getAttributes().getIntelligence();
        Assertions.assertEquals(5,strength);
        Assertions.assertEquals(2,dexterity);
        Assertions.assertEquals(1,intelligence);
    }

    @Test
    public void rangerShouldHaveDefaultAttributesAtLevelOne()
    {
        Character character = new Ranger("Love");
        int strength = character.getAttributes().getStrength();
        int dexterity = character.getAttributes().getDexterity();
        int intelligence = character.getAttributes().getIntelligence();
        Assertions.assertEquals(1,strength);
        Assertions.assertEquals(7,dexterity);
        Assertions.assertEquals(1,intelligence);
    }

    @Test
    public void rogueShouldHaveDefaultAttributesAtLevelOne()
    {
        Character character = new Rogue("Love");
        int strength = character.getAttributes().getStrength();
        int dexterity = character.getAttributes().getDexterity();
        int intelligence = character.getAttributes().getIntelligence();
        Assertions.assertEquals(2,strength);
        Assertions.assertEquals(6,dexterity);
        Assertions.assertEquals(1,intelligence);
    }
    @Test
    public void mageShouldHaveCorrectAttributesWhenLevelTwo()
    {
        Character character = new Mage("Love");
        character.levelUp();
        int strength = character.getAttributes().getStrength();
        int dexterity = character.getAttributes().getDexterity();
        int intelligence = character.getAttributes().getIntelligence();
        Assertions.assertEquals(2,strength);
        Assertions.assertEquals(2,dexterity);
        Assertions.assertEquals(13,intelligence);
    }

    @Test
    public void warriorShouldHaveCorrectAttributesWhenLevelTwo()
    {
        Character character = new Warrior("Love");
        character.levelUp();
        int strength = character.getAttributes().getStrength();
        int dexterity = character.getAttributes().getDexterity();
        int intelligence = character.getAttributes().getIntelligence();
        Assertions.assertEquals(8,strength);
        Assertions.assertEquals(4,dexterity);
        Assertions.assertEquals(2,intelligence);
    }

    @Test
    public void rangerShouldHaveCorrectAttributesWhenLevelTwo()
    {
        Character character = new Ranger("Love");
        character.levelUp();
        int strength = character.getAttributes().getStrength();
        int dexterity = character.getAttributes().getDexterity();
        int intelligence = character.getAttributes().getIntelligence();
        Assertions.assertEquals(2,strength);
        Assertions.assertEquals(12,dexterity);
        Assertions.assertEquals(2,intelligence);
    }

    @Test
    public void rogueShouldHaveCorrectAttributesWhenLevelTwo()
    {
        Character character = new Rogue("Love");
        character.levelUp();
        int strength = character.getAttributes().getStrength();
        int dexterity = character.getAttributes().getDexterity();
        int intelligence = character.getAttributes().getIntelligence();
        Assertions.assertEquals(3,strength);
        Assertions.assertEquals(10,dexterity);
        Assertions.assertEquals(2,intelligence);
    }
}