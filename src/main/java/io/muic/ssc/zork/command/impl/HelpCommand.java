package io.muic.ssc.zork.command.impl;

import java.io.*;
import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;

public class HelpCommand implements Command {

    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("\u001B[95m'help'\u001B[0m does not have any argument, please try again.");
        } else {
            try (FileReader fileReader = new FileReader("src/main/java/io/muic/ssc/zork/allCommandInfo.txt");) {
                int content;
                while ((content = fileReader.read()) != -1) {
                    System.out.print((char) content);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
