package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.room.Direction;
import io.muic.ssc.zork.command.Command;
import static io.muic.ssc.zork.Game.player;
import static io.muic.ssc.zork.Game.currentMap;
import static io.muic.ssc.zork.room.Direction.getDirection;

public class GoCommand implements Command {

    @Override
    public void execute(Game game, String argument) {
        if (currentMap != null) {
            if (argument == null) {
                System.out.println("please enter direction (north, east, west, south)");
            } else if (getDirection(argument) == null) {
                System.out.println("Please try again.");
            } else {
                Direction d = getDirection(argument);
                assert d != null;
                if (player.getCurrentRoom().getExit(d) != null) {
                    // player is moving
                    System.out.printf("\u001B[93m[ %s ]\u001B[0m ...ᕕ( ᐛ )ᕗ", player.getCurrentRoom().getRoomName());
                    player.setCurrentRoom(player.getCurrentRoom().getExit(d));
                    System.out.printf(" \u001B[93m[ %s ]\u001B[m\n", player.getCurrentRoom().getRoomName());

                    // new current room description
                    System.out.println(player.getCurrentRoom().getDescription());

                    // print status of this room (weapon, item, monster)
                    if (player.getCurrentRoom().getItem() != null) {
                        System.out.printf("item in this room: \u001B[96m%s\u001B[0m\n", player.getCurrentRoom().getItem().getItemName());
                    }
                    if (player.getCurrentRoom().getMonster() != null) {
                        System.out.printf("monster in this room: \u001B[91m%s\u001B[0m, %s\n", player.getCurrentRoom().getMonster().getMonsName(), player.getCurrentRoom().getMonster().getMonsDescription());
                    }
                }
                else { System.out.printf("There is a wall!, you cannot go %s!%n", argument); }
            }
        } else {
            System.out.println("this command only available while playing game. \n" +
                    "please enter the game by typing \u001B[95m'play'\u001B[0m followed by the map you want to play.");
        }
    }
}
