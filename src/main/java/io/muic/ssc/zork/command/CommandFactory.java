package io.muic.ssc.zork.command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    // create command from ENUM CommandType.
    // The actual command will be stored in the map here. to execute the command, it will need to access from here.
    private static Map<CommandType, Command> commandMap = new HashMap<>();
    static {
        for (CommandType commandType : CommandType.values()) {
            Command command;
            try {
                command = (Command) commandType.getCommandClass().getDeclaredConstructor().newInstance();
                commandMap.put(commandType, command);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    public static Command get(CommandType commandType) {
        return commandMap.get(commandType);
    }
}
