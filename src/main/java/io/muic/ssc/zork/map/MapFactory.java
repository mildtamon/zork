package io.muic.ssc.zork.map;

public class MapFactory {

    public static Map createMap(MapType mapType, String mapName, String mapDescription) {
        try {
            return mapType.getMapClass().getDeclaredConstructor(String.class, String.class).newInstance(mapName, mapDescription);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Unknown map");
    }
}
