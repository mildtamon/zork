package io.muic.ssc.zork.map.impl;

import io.muic.ssc.zork.item.ItemType;
import io.muic.ssc.zork.map.Map;
import io.muic.ssc.zork.moster.Monster;
import io.muic.ssc.zork.moster.impl.Boss;
import io.muic.ssc.zork.moster.impl.Skeleton;
import io.muic.ssc.zork.moster.impl.Slime;
import io.muic.ssc.zork.moster.impl.Zombie;
import io.muic.ssc.zork.room.Room;

import static io.muic.ssc.zork.Game.player;

public class AbandoHouseMap implements Map {
    private String mapName;
    private String mapDescription;

    private Monster BOSS = new Boss("boss", "Kill the boss to finish this map", 14, 60);

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
        Room frontYard, livingRoom, diningRoom, kitchen, hallway, gym, storage, bedroom, bathroom, library, workRoom;
        frontYard = new Room("front yard", "Muddy yard, no one has been here for a while.");
        livingRoom = new Room("living room", "The living room is a mess, so no one lived here ...?");
        diningRoom = new Room("dining room", "There is a steak, is it still edible?");
        kitchen = new Room("kitchen", "It still have some ingredient, too bad I can't cook.");
        hallway = new Room("hallway", "It's a long hallway");
        gym = new Room("gym", "The owner used to work out here.");
        storage = new Room("storage", "This room might have something useful?");
        bedroom = new Room("bedroom", "This room looks neat, maybe the owner keep something important here?");
        bathroom = new Room("bathroom", "I'm thirsty");
        library = new Room("library", "A big library, I might find something useful here.");
        workRoom = new Room("work room", "What is that ...?");

        // link the rooms
        frontYard.setExit(livingRoom, null, null, null);
        livingRoom.setExit(diningRoom, null, hallway, frontYard);
        diningRoom.setExit(null, null, kitchen, livingRoom);
        kitchen.setExit(null, diningRoom, null, null);
        hallway.setExit(library, livingRoom, bedroom, null);
        gym.setExit(storage, null, null, null);
        storage.setExit(bedroom, null, null, gym);
        bedroom.setExit(bathroom, null, null, storage);
        bathroom.setExit(null, null, null, bedroom);
        library.setExit(null, workRoom, null, hallway);
        workRoom.setExit(null, null, library, null);

        // create item
        frontYard.setItem(ItemType.WOODENSTICK);
        livingRoom.setItem(ItemType.WOODENSWORD);
        diningRoom.setItem(ItemType.STEAK);
        kitchen.setItem(ItemType.BREAD);
        hallway.setItem(ItemType.IRONSWORD);
        gym.setItem(ItemType.APPLE);
        storage.setItem(ItemType.POTION);
        bedroom.setItem(ItemType.DIAMONDSWORD);
        bathroom.setItem(ItemType.POTION);
        library.setItem(ItemType.POTION);

        // create monster
        frontYard.setMonster(new Slime("muddy slime", "It's jumping on a wooden stick. This can be a better weapon than bare hands"));
        livingRoom.setMonster(new Zombie("home owner zombie", "Looks like he used to be the owner of this house."));
        kitchen.setMonster(new Slime("moldy slime", "It is eating a bread, better kill them before they eat all the bread."));
        hallway.setMonster(new Skeleton("butler skeleton", "It is guarding a sword, should we take that?"));
        gym.setMonster(new Slime("oily slime", "Looks like it's been in the gym for a long time."));
        storage.setMonster(new Zombie("zombie", "Just a zombie"));
        bathroom.setMonster(new Slime("slime", "Just a slime"));
        library.setMonster(new Skeleton("skeleton", "He is guarding a working room"));
        workRoom.setMonster(BOSS);

        // set the first location to be at ...
        player.currentRoom = frontYard;
    }

    @Override
    public String getRoomDescription() {
        return String.format("* Map: %s \n* You are at %s. %s", getMapName(), player.getCurrentRoom().getRoomName(), player.getCurrentRoom().getDescription());
    }

    String AbandonHouseLevelMap =
           """
                   ╋=============================================================╋
                   #                                  |                          #
                   #                                  |                          #
                   #                                  ⊥                          #
                   #              library                      work room         #
                   #                                  ⊤                          #
                   #                                  |                          #
                   #                                  |                          #
                   ╋-----------------╋----[   ]----+--+------+-------------------╋
                   #                 |             |         |                   #
                   #     bathroom    |             |         ⊥                   #
                   #                 |             | kitchen         dining      #
                   #                 |   hallway   |                  room       #
                   #------[   ]------|             |         ⊤                   #
                   #                 ⊥             |         |                   #
                   #     bedroom              ╋====╋=========╋===========[    ]==╋
                   #                 ⊤        |                                  #
                   #                 |        ⊥                                  #
                   #------[   ]------|                     living room           #
                   #                 |        ⊤                                  #
                   #     storage     |        |                                  #
                   #                 |        |                                  #
                   #                 |        #===================[       ]======╋
                   #------[   ]------|        #
                   #                 |        #             ................
                   #       gym       |        #         ...                 ...
                   #                 |        #       ..                       ..
                   #                 |        #      .         front yard        :
                   ╋=================╋========╋       :                         .
                                                        ...                   ..
                                                           ..................
                    """;

    @Override
    public String printMap() {
        return String.format("[Map] %s: %s\n", this.getMapName(), this.getMapDescription()) + AbandonHouseLevelMap;
    }

    @Override
    public boolean isFinishedMap() {
        return !BOSS.isAlive();
    }
}
