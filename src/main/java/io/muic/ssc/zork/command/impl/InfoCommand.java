package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;

public class InfoCommand implements Command {

    @Override
    public void execute(Game game) {
        System.out.println("Print Info");
    }
}
