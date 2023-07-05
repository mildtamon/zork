package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.room.Direction;

import static io.muic.ssc.zork.Game.player;
import static io.muic.ssc.zork.room.Direction.getDirection;

public class GoCommand implements Command {

    @Override
    public void execute(Game game, String argument) {
        if (argument == null) {
            System.out.println("please enter direction (north, east, west, south)");
        } else if (getDirection(argument) == null) {
            System.out.println("Please try again.");

        } else {
            Direction d = getDirection(argument);
            assert d != null;
            if (player.getCurrentRoom().getExit(d) != null) {
                // player is moving
                System.out.print("Moving from " + player.getCurrentRoom().getRoomName());
                player.setCurrentRoom(player.getCurrentRoom().getExit(d));
                System.out.printf(" to %s. ", player.getCurrentRoom().getRoomName());

                // new current room description
                System.out.println(player.getCurrentRoom().getDescription());

                // print status of this room (weapon, item, monster)
                if (player.getCurrentRoom().getItem() != null) {
                    System.out.println("item in this room: " + player.getCurrentRoom().getItem().getItemName());
                }
                if (player.getCurrentRoom().getMonster() != null) {
                    System.out.println("monster in this room: " + player.getCurrentRoom().getMonster().getMonsterName());
                }
            }
            else { System.out.printf("There is a wall!, you cannot go %s!%n", argument); }
        }
    }
}
