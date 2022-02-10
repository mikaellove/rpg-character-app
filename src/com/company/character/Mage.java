package com.company.character;

import java.util.logging.Logger;

public class Mage extends Character{
    public Mage(String name) {
        super(name);

        attributes.baseDexterity = 1;
        attributes.baseIntelligence = 8;
        attributes.baseStrength = 1;
    }

    @Override
    public void levelUp() {
        level += 1;

        attributes.baseDexterity += 1;
        attributes.baseStrength += 1;
        attributes.baseIntelligence += 5;
    }
}
