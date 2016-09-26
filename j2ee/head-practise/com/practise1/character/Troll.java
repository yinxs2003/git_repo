package com.practise1.character;

import com.practise1.behavior.WeaponBehavior;

public class Troll extends Character {

    private WeaponBehavior weaponBehavior;

    public Troll(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
