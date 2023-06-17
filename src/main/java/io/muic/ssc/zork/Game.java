package io.muic.ssc.zork;

import io.muic.ssc.zork.command.*;

import java.util.Scanner;

public class Game {

    private boolean exit = false;
    // The Scanner class is used to get user input, create scanner to scan input command
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

            CommandLine commandLine = CommandParser.parseCommand(rawInput);
            if (commandLine == null) {
                System.out.println("Invalid command, please try again");
            } else {
                Command command = CommandFactory.get(commandLine.getCommandType());
                command.execute(this, commandLine.getArgument());
            }
        }
    }
}
