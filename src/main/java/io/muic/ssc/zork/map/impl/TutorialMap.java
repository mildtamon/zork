package io.muic.ssc.zork.map.impl;

import io.muic.ssc.zork.map.Map;

public class TutorialMap implements Map {
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

    public TutorialMap(String mapName, String mapDescription) {
        setMapName(mapName);
        setMapDescription(mapDescription);
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
