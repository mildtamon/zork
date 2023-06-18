package io.muic.ssc.zork.map.impl;

import io.muic.ssc.zork.map.Map;
import io.muic.ssc.zork.room.Room;

public class TutorialMap implements Map {
    private String mapName;
    private String mapDescription;
    private Room currentRoom;

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

    public TutorialMap(String mapName, String mapDescription) {
        setMapName(mapName);
        setMapDescription(mapDescription);
        createRooms();
    }

    @Override
    public void createRooms() {
        // create the rooms
        Room lobby, storage, trainingRoom1, trainingRoom2, boss;
        lobby = new Room("Lobby", "This is the main room of this map.");
        storage = new Room("Storage room", "Get your weapon and be ready to fight!");
        trainingRoom1 = new Room("training room 1", "Hit your first monster here!");
        trainingRoom2 = new Room("training room 2", "Practice fighting before going to the boss battle!");
        boss = new Room("boss room", "Fight again the boss to pass the level");

        // link the rooms
        lobby.setExit(storage, null, null, null);
        storage.setExit(boss, trainingRoom2, trainingRoom1, lobby);
        trainingRoom1.setExit(null, storage, null, null);
        trainingRoom2.setExit(null, null, storage, null);
        boss.setExit(null, null, null, storage);

        currentRoom = lobby;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }

    @Override
    public String getRoomDescription() {
        return String.format("* Map: %s \n* You are at %s. %s", getMapName(), getCurrentRoom().getRoomName(), getCurrentRoom().getDescription());
    }

    String tutorialLevelMap =
            """
            ============================================================
            #                                                          #
            #               +--------------------------+               #
            #               |                          |               #
            #               |        FIRST BOSS        |               #
            #               |                          |               #
            #               +___________    ___________+               #
            #                           |  |                           #
            #   +----------+   +--------+  +--------+   +----------+   #
            #   |          |___|                    |___           |   #
            #   | training  ___        storage       ___  training |   #
            #   |  room 1  |   |                    |   |  room 2  |   #
            #   +----------+   +--------+  +--------+   +----------+   #
            #                           |  |                           #
            #                      +----+  +----+                      #
            #                      |            |                      #
            #                      |   lobby    |                      #
            #                      |            |                      #
            #                      +---+    +---+                      #
            #                          |    |                          #
            ============================    ============================""";

    @Override
    public String printMap() {
        return String.format("[Map] %s: %s\n", this.getMapName(), this.mapDescription) + tutorialLevelMap;
    }
}
