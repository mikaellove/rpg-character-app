package com.company.equipment;

import com.company.PrimaryAttribute;

/**
 * Child of Item.java
 * Contains damage and attack speed which are set when an instance of this class is created.
 * Contains a method for calculating the weapons DPS.
 * The name, level and slot are passed down into the base class constructor.
 */
public class Weapon extends Item{
    private WeaponType type;
    private int damage;
    private double attackSpeed;

    public Weapon(String name, int level,int damage, double attackSpeed, WeaponType weaponType) {
        super(name, level, Slot.WEAPON);

        this.type = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public double GetWeaponDPS()
    {
        double dps = damage * attackSpeed;

        return dps;
    }

    public WeaponType getType() {
        return type;
    }
}
