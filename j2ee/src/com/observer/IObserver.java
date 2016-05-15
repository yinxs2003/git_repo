package com.observer;

import java.util.Observable;
import java.util.Observer;

public class IObserver implements Observer {
    private int myState;


    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcretSubject) o).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
