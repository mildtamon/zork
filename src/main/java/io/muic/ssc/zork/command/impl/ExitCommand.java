package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;

public class ExitCommand implements Command {

    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("'exit' does not have any argument, please try again");
        } else {
            System.out.println("Exiting the game. Thank you for playing Zork ;)");
            game.exit();
        }
    }
}
