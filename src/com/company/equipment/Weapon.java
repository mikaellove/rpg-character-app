package com.company.equipment;

import com.company.PrimaryAttribute;

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
