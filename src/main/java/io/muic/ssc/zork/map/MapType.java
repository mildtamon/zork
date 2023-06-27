package io.muic.ssc.zork.map;

import io.muic.ssc.zork.map.impl.TutorialMap;
import io.muic.ssc.zork.room.Direction;

import java.util.Objects;

import static io.muic.ssc.zork.Game.allMaps;

public enum MapType {
    TUTORIAL(TutorialMap.class, "Tutorial", "This is tutorial level to let the player familiar with the game and command");

    private Class<? extends Map> mapClass;
    private String mapName;
    private String mapDescription;

    MapType(Class<? extends Map> mapClass, String mapName, String mapDescription) {
        this.mapClass = mapClass;
        this.mapName = mapName;
        this.mapDescription = mapDescription;
    }

    public Class getMapClass() {
        return mapClass;
    }

    public String getMapName() {
        return mapName;
    }

    public String getMapDescription() {
        return mapDescription;
    }

    public static Map getMap(String mapName) {
        for (MapType mapType : MapType.values()) {
            if (Objects.equals(mapName, mapType.mapName)) {
                return MapFactory.createMap(mapType, mapType.getMapName(), mapType.getMapDescription());
            }
        }
        return null;
    }
}
