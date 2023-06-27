package io.muic.ssc.zork.command;

import io.muic.ssc.zork.command.impl.*;

public enum CommandType {
    INFO(InfoCommand.class, "info"),
    EXIT(ExitCommand.class, "exit"),
    HELP(HelpCommand.class, "help"),
    MAP(MapCommand.class, "map"),
    GO(GoCommand.class, "go"),
    TAKE(TakeCommand.class, "take");

    private Class<? extends Command> commandClass;      // need to get class -> so we know which command class to execute
    private String commandWord;

    CommandType(Class<? extends Command> commandClass, String commandWord) {
        this.commandClass = commandClass;
        this.commandWord = commandWord;
    }

    public Class getCommandClass() {
        return commandClass;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public boolean match(String rawInput) {
        return rawInput.startsWith(commandWord);
    }
}
