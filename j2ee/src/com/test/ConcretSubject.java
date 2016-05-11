package com.test;

import java.util.Observable;

/**
 * Created by yinxuesong on 2016/5/11.
 */
public class ConcretSubject extends Observable{
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void set(int s){
        state = s;
        setChanged();
        notifyObservers(state);
    }
}
