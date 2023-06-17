package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

public class InfoCommand implements Command {

    @Override
    public void execute(Game game) {
        System.out.println("Print Info");
    }
}
