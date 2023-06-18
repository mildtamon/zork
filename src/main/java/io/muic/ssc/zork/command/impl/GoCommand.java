package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;

import static io.muic.ssc.zork.Game.currentMap;
import static io.muic.ssc.zork.Game.player;
import static io.muic.ssc.zork.player.Player.currentRoom;
import static io.muic.ssc.zork.room.Direction.getDirection;

public class GoCommand implements Command {

    @Override
    public void execute(Game game, String argument) {
        if (argument == null) {
            System.out.println("please enter direction (north, east, west, south)");
        } else if (getDirection(argument) == null) {
            System.out.println("Please try again.");
        } else {
            switch (getDirection(argument)) {
                case NORTH -> {
                    System.out.println("current room is " + currentRoom.getRoomName());
                    currentRoom = currentRoom.northExit;
                    System.out.println("going north");
                    System.out.println("going to " + currentRoom.northExit.getRoomName());
                }
                case EAST -> {
                    System.out.println("going east");
                }
                case WEST -> {
                    System.out.println("going west");
                }
                case SOUTH -> {
                    System.out.println("going south");
                }
            }
        }
    }
}
