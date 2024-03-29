package io.muic.ssc.zork.map.impl;

import io.muic.ssc.zork.map.Map;
import io.muic.ssc.zork.moster.impl.Slime;
import io.muic.ssc.zork.room.Room;
import io.muic.ssc.zork.item.ItemType;
import io.muic.ssc.zork.moster.Monster;
import io.muic.ssc.zork.moster.impl.Boss;
import io.muic.ssc.zork.moster.impl.Zombie;
import static io.muic.ssc.zork.Game.player;


public class TutorialMap implements Map {
    private String mapName;
    private String mapDescription;

    private Monster BOSS = new Boss("boss", "this is the first boss! kill him to finish the map", 10, 30);

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
        boss = new Room("boss room", "Fight against the boss to pass the level");

        // link the rooms
        lobby.setExit(storage, null, null, null);
        storage.setExit(boss, trainingRoom2, trainingRoom1, lobby);
        trainingRoom1.setExit(null, storage, null, null);
        trainingRoom2.setExit(null, null, storage, null);
        boss.setExit(null, null, null, storage);

        // create item
        storage.setItem(ItemType.WOODENSWORD);
        trainingRoom1.setItem(ItemType.WOODENSTICK);
        trainingRoom2.setItem(ItemType.POTION);

        // create monster
        trainingRoom1.setMonster(new Slime("slime", "Kill the guarding slime to get the sword."));
        trainingRoom2.setMonster(new Zombie("zombie", "Kill the guarding zombie to get potion."));
        boss.setMonster(BOSS);

        // set the first location to be at lobby.
        player.currentRoom = lobby;
    }

    @Override
    public String getRoomDescription() {
        return String.format("* Map: %s \n* You are at %s. %s", getMapName(), player.getCurrentRoom().getRoomName(), player.getCurrentRoom().getDescription());
    }

    String tutorialLevelMap =
            """
            ╋==========================================================╋
            #                                                          #
            #               ╋--------------------------╋               #
            #               |                          |               #
            #               |        FIRST BOSS        |               #
            #               |                          |               #
            #               ╋___________    ___________╋               #
            #                           |  |                           #
            #   +----------+   +--------+  +--------+   +----------+   #
            #   |          |___|                    |___|          |   #
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
            ╋==========================╋    ╋==========================╋""";

    @Override
    public String printMap() {
        return String.format("[Map] %s: %s\n", this.getMapName(), this.getMapDescription()) + tutorialLevelMap;
    }

    @Override
    public boolean isFinishedMap() {
        return !BOSS.isAlive();
    }
}
