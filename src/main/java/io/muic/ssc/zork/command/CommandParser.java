package io.muic.ssc.zork.command;

import org.apache.commons.lang3.StringUtils;

public class CommandParser {

    // turn raw input String to CommandLine
    public static CommandLine parseCommand(String rawInput) {
        for (CommandType commandType : CommandType.values()) {
            // check if the raw input is a valid command
            if (commandType.match(rawInput)) {
                // remove the command word and trim to get the arguments
                String argument = rawInput.replace(commandType.getCommandWord(), "").trim();
                // if there is no argument, set to null
                argument = StringUtils.isBlank(argument)? null : argument;
                return new CommandLine(commandType, argument);
            }
        }
        return null;
    }
}
