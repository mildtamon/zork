package io.muic.ssc.zork.map;

import io.muic.ssc.zork.map.impl.TutorialMap;

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

    public Class<? extends Map> getMapClass() {
        return mapClass;
    }

    public String getMapName() {
        return mapName;
    }

    public String getMapDescription() {
        return mapDescription;
    }
}
