package com.company;

public class PrimaryAttribute {
    private int baseStrength;

    public int getStrength() {
        return baseStrength;
    }

    public void setStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    }

    public int getDexterity() {
        return baseDexterity;
    }

    public void setDexterity(int baseDexterity) {
        this.baseDexterity = baseDexterity;
    }

    public int getIntelligence() {
        return baseIntelligence;
    }

    public void setIntelligence(int baseIntelligence) {
        this.baseIntelligence = baseIntelligence;
    }

    private int baseDexterity;
    private int baseIntelligence;

    public PrimaryAttribute(int baseStrength, int baseDexterity, int baseIntelligence) {
        this.baseStrength = baseStrength;
        this.baseDexterity = baseDexterity;
        this.baseIntelligence = baseIntelligence;
    }
}
