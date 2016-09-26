package com.command3;

import com.command2.Command;

public class CeilingFanHighCommand implements Command {
    CeilingFan ceilingFan;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        ceilingFan.high();
    }

    @Override
    public void undo() {
        ceilingFan.medium();
    }
}
