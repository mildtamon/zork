package io.muic.ssc.zork.map;

import io.muic.ssc.zork.room.Room;

public interface Map {

    void createRooms();
    String getMapName();
    String getRoomDescription();
    String printMap();
    boolean isFinishedMap();
}
