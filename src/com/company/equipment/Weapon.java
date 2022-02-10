package com.company.equipment;

import com.company.PrimaryAttribute;

public class Weapon extends Item{
    public WeaponType type;
    private int damage;
    private double attackSpeed;

    public Weapon(PrimaryAttribute attributes, String name, int level, Slot slot,int damage, double attackSpeed, WeaponType weaponType) {
        super(attributes, name, level, slot);

        this.type = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public double GetWeaponDPS()
    {
        double dps = damage * attackSpeed;
        int castedDPS = (int) dps;

        return castedDPS;
    }
}
