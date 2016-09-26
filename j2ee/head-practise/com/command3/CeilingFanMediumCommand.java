package com.command3;

import com.command2.Command;

public class CeilingFanMediumCommand implements Command {
    CeilingFan ceilingFan;

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        ceilingFan.medium();
    }

    @Override
    public void undo() {
        ceilingFan.low();
    }
}
