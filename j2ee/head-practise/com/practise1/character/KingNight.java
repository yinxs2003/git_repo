package com.practise1.character;

import com.practise1.behavior.WeaponBehavior;

public class KingNight extends Character {
    private WeaponBehavior weaponBehavior;

    public KingNight(WeaponBehavior w) {
        weaponBehavior = w;
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
