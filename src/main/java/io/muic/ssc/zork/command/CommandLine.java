package io.muic.ssc.zork.command;

public class CommandLine {

    private CommandType commandType;
    private String argument;

    // command line consist of CommandType and argument, ready to be used.
    public CommandLine(CommandType commandType, String argument) {
        this.commandType = commandType;
        this.argument = argument;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public String getArgument() {
        return argument;
    }
}
