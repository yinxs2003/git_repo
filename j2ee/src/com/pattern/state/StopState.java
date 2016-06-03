package com.pattern.state;

public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is set to Stop State.");
        context.setState(this);
    }

    public String toString() {
        return "stop state";
    }
}
