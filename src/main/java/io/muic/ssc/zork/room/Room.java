package io.muic.ssc.zork.room;

public class Room {

    String roomName;
    String roomDescription;
    Room northExit, eastExit, westExit, southExit;

    public Room(String roomName, String description) {
        this.roomName = roomName;
        this.roomDescription = description;
    }

    public String getDescription() {
        return roomDescription;
    }

    public void setExit(Direction direction, Room neighbor) {
        switch (direction) {
            case NORTH: northExit = neighbor;
            case EAST: eastExit = neighbor;
            case WEST: westExit = neighbor;
            case SOUTH: southExit = neighbor;
        }
    }
}
