package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;

public class ExitCommand implements Command {

    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("\u001B[95m'exit'\u001B[0m does not have any argument, please try again.");
        } else {
            System.out.println("Exiting the game. Thank you for playing \u001B[93mZork\u001B[0m ;)");
            game.exit();
        }
    }
}
