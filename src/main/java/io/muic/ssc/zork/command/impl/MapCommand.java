package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;

import static io.muic.ssc.zork.Game.currentMap;

public class MapCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("'map' does not have any argument, please try again");
        } else {
            System.out.println(currentMap.printMap());
        }
    }
}
