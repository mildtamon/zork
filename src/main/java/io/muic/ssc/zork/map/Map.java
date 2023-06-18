package io.muic.ssc.zork.map;

import io.muic.ssc.zork.room.Room;

public interface Map {

    void createRooms();
    String getRoomDescription();
    String printMap();
}
