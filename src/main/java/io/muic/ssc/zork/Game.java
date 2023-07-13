package io.muic.ssc.zork;

import io.muic.ssc.zork.command.*;
import io.muic.ssc.zork.map.Map;
import io.muic.ssc.zork.map.MapType;
import io.muic.ssc.zork.player.Player;
import io.muic.ssc.zork.map.MapFactory;

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

        for (MapType mapType : MapType.values()) {
            allMaps.add(MapFactory.createMap(mapType, mapType.getMapName(), mapType.getMapDescription()));
        }

        System.out.printf("type \u001B[95m'play'\u001B[0m and choose map to play! [");
        for (Map each : allMaps) {
            System.out.printf("\u001B[96m%s\u001B[0m/", each.getMapName());
        }
        System.out.println("...]");

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
