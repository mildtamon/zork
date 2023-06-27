package io.muic.ssc.zork.room;

import io.muic.ssc.zork.item.Item;
import io.muic.ssc.zork.item.ItemType;

public class Room {

    String roomName;
    String roomDescription;
    public Room northExit, eastExit, westExit, southExit;

    public ItemType getItem() {
        return item;
    }

    public void setItem(ItemType item) {
        this.item = item;
    }

    ItemType item;

    public Room(String roomName, String description) {
        this.roomName = roomName;
        this.roomDescription = description;
    }

    public Room getExit(Direction direction) {
        switch (direction) {
            case NORTH -> {
                return this.northExit;
            }
            case EAST -> {
                return this.eastExit;
            }
            case WEST -> {
                return this.westExit;
            }
            case SOUTH -> {
                return this.southExit;
            }
        }
        return null;
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
