package io.muic.ssc.zork.room;

public enum Direction {
    NORTH, EAST, WEST, SOUTH;

    public static Direction getDirection(String direction) {
        switch (direction) {
            case "north" -> {
                return Direction.NORTH;
            }
            case "east" -> {
                return Direction.EAST;
            }
            case "west" -> {
                return Direction.WEST;
            }
            case "south" -> {
                return Direction.SOUTH;
            }
            default -> System.out.printf("invalid direction '%s' ", direction);
        }
        return null;
    }
}
