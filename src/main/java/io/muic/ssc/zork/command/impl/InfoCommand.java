package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;

import static io.muic.ssc.zork.Game.currentMap;
import static io.muic.ssc.zork.Game.player;

public class InfoCommand implements Command {

    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("'info' does not have any argument, please try again");
        } else {
            System.out.println("[[ player info ]]");
            System.out.println(player.playerInfo());
            System.out.println("\n[[ location info ]]");
            System.out.println(currentMap.getRoomDescription());
        }

    }
}
