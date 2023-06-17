package io.muic.ssc.zork.command;

import io.muic.ssc.zork.command.impl.ExitCommand;
import io.muic.ssc.zork.command.impl.InfoCommand;

public enum CommandType {
    INFO(InfoCommand.class),
    EXIT(ExitCommand.class);

    private Class<? extends Command> commandClass;

    CommandType(Class<? extends Command> commandClass) {
        this.commandClass = commandClass;
    }

    public Class getCommandClass() {
        return commandClass;
    }
}
