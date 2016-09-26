package com.practise1.character;

import com.practise1.behavior.WeaponBehavior;

public class Queen extends Character {
    private WeaponBehavior weaponBehavior;

    public Queen(WeaponBehavior w) {
        this.weaponBehavior = w;
    }

    public void setWeaponBehavior(WeaponBehavior w) {
        this.weaponBehavior = w;
    }

    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
