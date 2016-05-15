package com.observer;

import java.util.Observable;


public class ConcretSubject extends Observable {
    private int state;

    public int getState() {
        return state;
    }


    public void set(int s) {
        state = s;
        setChanged();
        notifyObservers(state);
    }
}
