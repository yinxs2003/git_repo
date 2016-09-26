package com.practise.test;

import com.practise1.behavior.AxeBehavior;
import com.practise1.character.KingNight;

import java.util.Observable;

public class CharacterTest {
    public static void main(String[] args) {
        Observable observable = new Observable();
        KingNight kingNight = new KingNight(new AxeBehavior());
        kingNight.fight();
    }
}
