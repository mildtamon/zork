package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;
import static io.muic.ssc.zork.Game.player;
import static io.muic.ssc.zork.Game.currentMap;

public class InfoCommand implements Command {

    @Override
    public void execute(Game game, String argument) {
        if (currentMap != null) {
            if (argument != null) {
                System.out.println("\u001B[95m'info'\u001B[0m does not have any argument, please try again.");
            } else {
                System.out.println("\u001B[93m[[ player info ]]\u001B[0m");
                System.out.println(player.playerInfo());
                System.out.println("\n\u001B[93m[[ location info ]]\u001B[0m");
                System.out.println(currentMap.getRoomDescription());
            }
        } else {
            System.out.println("this command only available while playing game. \n" +
                    "please enter the game by typing \u001B[95m'play'\u001B[0m followed by the map you want to play.");
        }
    }
}
