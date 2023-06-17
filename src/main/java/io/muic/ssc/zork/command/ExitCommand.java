package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

public class ExitCommand implements Command {

    @Override
    public void execute(Game game) {
        game.exit();
    }
}
