package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.room.Direction;

import static io.muic.ssc.zork.Game.currentMap;
import static io.muic.ssc.zork.Game.player;
import static io.muic.ssc.zork.player.Player.*;
import static io.muic.ssc.zork.room.Direction.NORTH;
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
                System.out.println("you were at " + player.getCurrentRoom().getRoomName());
                player.setCurrentRoom(player.getCurrentRoom().getExit(d));
                System.out.println("now you are at " + player.getCurrentRoom().getRoomName());
            }
            else { System.out.printf("There is a wall!, you cannot go %s!%n", argument); }
        }
    }
}
