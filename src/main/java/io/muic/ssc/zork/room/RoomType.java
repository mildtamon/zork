package io.muic.ssc.zork.room;

public enum RoomType {

    LOBBY();

    private Class<? extends Room> roomClass;

}
