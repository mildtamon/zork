package io.muic.ssc.zork;

import io.muic.ssc.zork.command.*;
import io.muic.ssc.zork.map.Map;
import io.muic.ssc.zork.map.MapFactory;
import io.muic.ssc.zork.map.MapType;
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
        System.out.println(">> starting Zork... <<");
        System.out.println("type 'help' for list of commands");

        // create player
        player = new Player();

        // create map
        currentMap = null;
//        MapFactory.createMap(MapType.TUTORIAL, MapType.TUTORIAL.getMapName(), MapType.TUTORIAL.getMapDescription());

        System.out.println("type 'play' and choose map to play! [Tutorial / ...]");

//        for (MapType mapType : MapType.values()) {
//            allMaps.add(MapFactory.createMap(mapType, mapType.getMapName(), mapType.getMapDescription()));
//        }

//        currentMap = MapFactory.createMap(MapType.TUTORIAL, MapType.TUTORIAL.getMapName(), MapType.TUTORIAL.getMapDescription());

        while (!isExit() && scanner.hasNextLine()) {
            String rawInput = scanner.nextLine();

            CommandLine commandLine = CommandParser.parseCommand(rawInput);
            if (commandLine == null) {
                System.out.printf("Invalid command '%s', please try again.\n", rawInput);
            } else {
                Command command = CommandFactory.get(commandLine.getCommandType());
                command.execute(this, commandLine.getArgument());
            }
        }
    }
}
