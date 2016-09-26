package com.practise1.character;

import com.practise1.behavior.WeaponBehavior;

public class King extends Character {
    private WeaponBehavior weaponBehavior;

    public King(WeaponBehavior w) {
        weaponBehavior = w;
    }

    public void setWeaponBehavior(WeaponBehavior w) {
        weaponBehavior = w;
    }

    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
