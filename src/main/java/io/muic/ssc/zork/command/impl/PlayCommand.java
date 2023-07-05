package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;

import static io.muic.ssc.zork.Game.currentMap;
import static io.muic.ssc.zork.map.MapType.getMap;

public class PlayCommand implements Command {



    @Override
    public void execute(Game game, String argument) {
        if (argument == null) {
            System.out.println("please enter map name");
        } else if (getMap(argument) == null) {
            System.out.println("invalid map, Please try again.");
        } else {
            System.out.printf("open map %s ...\n\n", argument);
            currentMap = getMap(argument);
            System.out.println((currentMap.printMap()));
        }
    }
}
