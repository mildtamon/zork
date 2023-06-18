package io.muic.ssc.zork.room;

public class Room {

    String roomName;
    String roomDescription;
    Room northExit, eastExit, westExit, southExit;

    public Room(String roomName, String description) {
        this.roomName = roomName;
        this.roomDescription = description;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getDescription() {
        return roomDescription;
    }

    public void setExit(Room northNeighbor, Room eastNeighbor, Room westNeighbor, Room southNeighbor) {
        northExit = northNeighbor;
        eastExit = eastNeighbor;
        westExit = westNeighbor;
        southExit = southNeighbor;
    }
}
