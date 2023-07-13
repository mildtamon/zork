package io.muic.ssc.zork;

import io.muic.ssc.zork.command.*;
import io.muic.ssc.zork.map.Map;
import io.muic.ssc.zork.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    // The Scanner class is used to get user input, create scanner to scan input command
    private Scanner scanner = new Scanner(System.in);

    private boolean exit = false;
    public static Player player;
    public static Map currentMap;
    public static List<Map> allMaps = new ArrayList<>();

    public boolean isExit() {
        return exit;
    }

    public void exit() {
        this.exit = true;
        scanner.close();
    }

    public void start() {
        System.out.println("\u001B[93m >> starting Zork... <<\u001B[0m");
        System.out.println("type \u001B[95m'help'\u001B[0m for list of commands.");

        // create player
        player = new Player();

        // create map
        currentMap = null;
//        MapFactory.createMap(MapType.TUTORIAL, MapType.TUTORIAL.getMapName(), MapType.TUTORIAL.getMapDescription());

        System.out.println("type \u001B[95m'play'\u001B[0m and choose map to play! [\u001B[96mTutorial\u001B[0m / ...]");

//        for (MapType mapType : MapType.values()) {
//            allMaps.add(MapFactory.createMap(mapType, mapType.getMapName(), mapType.getMapDescription()));
//        }

//        currentMap = MapFactory.createMap(MapType.TUTORIAL, MapType.TUTORIAL.getMapName(), MapType.TUTORIAL.getMapDescription());

        while (!isExit() && scanner.hasNextLine()) {
            String rawInput = scanner.nextLine();

            CommandLine commandLine = CommandParser.parseCommand(rawInput);
            if (commandLine == null) {
                System.out.printf("Invalid command \u001B[93m'%s'\u001B[0m, please try again.\n", rawInput);
            } else {
                Command command = CommandFactory.get(commandLine.getCommandType());
                command.execute(this, commandLine.getArgument());
            }
        }
    }
}
