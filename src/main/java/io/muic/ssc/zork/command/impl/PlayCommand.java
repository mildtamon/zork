package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;
import static io.muic.ssc.zork.Game.currentMap;
import static io.muic.ssc.zork.map.MapType.getMap;

public class PlayCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (currentMap == null) {
            if (argument == null) {
                System.out.println("please enter map name.");
            } else if (getMap(argument) == null) {
                System.out.println("invalid map, Please try again.");
            } else {
                if (getMap(argument).isFinishedMap()) {
                    System.out.println("you have already finish this map, \u001B[93mZork\u001B[0m will restart the map");
                }
                System.out.printf("open map \u001B[96m%s\u001B[m ...\n", argument);
                currentMap = getMap(argument);
                System.out.println("type \u001B[95m'map'\u001B[0m to see your current map information!");
            }
        } else {
            System.out.println("you are already in a game!");
        }

    }
}
