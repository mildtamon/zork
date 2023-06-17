package io.muic.ssc.zork;

import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.command.CommandFactory;
import io.muic.ssc.zork.command.ExitCommand;

import java.util.Scanner;
import java.util.SortedMap;

public class Game {

    private boolean exit = false;
    // create scanner to scan input command
    private Scanner scanner = new Scanner(System.in);

    public boolean isExit() {
        return exit;
    }

    public void exit() {
        this.exit = true;
        scanner.close();
    }

    public void start() {
        System.out.println("Game started");

        while (!isExit() && scanner.hasNextLine()) {
            String rawInput = scanner.nextLine();
            System.out.println("You entered string " + rawInput);

            Command command = CommandFactory.get(rawInput);
            if (command == null) {
                System.out.println("Try again");
            } else {
                command.execute(this);
            }
        }
    }
}
