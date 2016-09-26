package com.practise1.behavior;

public class BowAndArrowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("kill with bow and arrow");
    }
}
