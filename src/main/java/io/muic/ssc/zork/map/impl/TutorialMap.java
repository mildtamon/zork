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
            ============================================================\s
            #                                                          #\s
            #               +__________________________+               #\s
            #               |                          |               #\s
            #               |        FIRST BOSS        |               #\s
            #               |                          |               #\s
            #               +___________    ___________+               #\s
            #                           |  |                           #\s
            #   +----------+   +--------+  +--------+   +----------+   #\s
            #   |          |___|                    |___           |   #\s
            #   | training  ___        storage       ___  training |   #\s
            #   |  room 1  |   |                    |   |  room 2  |   #\s
            #   +----------+   +--------+  +--------+   +----------+   #\s
            #                           |  |                           #\s
            #                      +----+  +----+                      #\s
            #                      |            |                      #\s
            #                      |   lobby    |                      #\s
            #                      |            |                      #\s
            #                      +---+    +---+                      #\s
            #                          |    |                          #\s
            ============================    ============================\s
            """;
    @Override
    public String printMap() {
        return String.format("[Map] %s: %s\n", this.getMapName(), this.mapDescription) + tutorialLevelMap;
    }
}
