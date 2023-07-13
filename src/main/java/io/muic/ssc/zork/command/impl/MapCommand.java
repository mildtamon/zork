package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;
import static io.muic.ssc.zork.Game.currentMap;

public class MapCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (currentMap != null) {
            if (argument != null) {
                System.out.println("\u001B[95m'map'\u001B[0m does not have any argument, please try again.");
            } else {
                System.out.println(currentMap.printMap());
            }
        } else {
            System.out.println("this command only available while playing game. \n" +
                    "please enter the game by typing \u001B[95m'play'\u001B[0m followed by the map you want to play.");
        }
    }
}
