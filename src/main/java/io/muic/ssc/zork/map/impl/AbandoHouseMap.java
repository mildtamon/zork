package io.muic.ssc.zork.map.impl;

import io.muic.ssc.zork.map.Map;

import static io.muic.ssc.zork.Game.player;

public class AbandoHouseMap implements Map {
    private String mapName;
    private String mapDescription;

    public String getMapName() {
        return mapName;
    }
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getMapDescription() {
        return mapDescription;
    }
    public void setMapDescription(String mapDescription) {
        this.mapDescription = mapDescription;
    }

    public AbandoHouseMap(String mapName, String mapDescription) {
        setMapName(mapName);
        setMapDescription(mapDescription);
        createRooms();
    }


    @Override
    public void createRooms() {
        // create the rooms

        // link the rooms

        // create item


        // set the first location to be at ...

    }

    @Override
    public String getRoomDescription() {
        return String.format("* Map: %s \n* You are at %s. %s", getMapName(), player.getCurrentRoom().getRoomName(), player.getCurrentRoom().getDescription());
    }

    String AbandonHouseLevelMap = "";

    @Override
    public String printMap() {
        return String.format("[Map] %s: %s\n", this.getMapName(), this.getMapDescription()) + AbandonHouseLevelMap;
    }
}
