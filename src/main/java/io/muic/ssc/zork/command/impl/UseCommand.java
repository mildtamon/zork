package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.item.ItemType;
import io.muic.ssc.zork.command.Command;
import static io.muic.ssc.zork.Game.player;
import static io.muic.ssc.zork.Game.currentMap;


public class UseCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (currentMap != null) {
            if (argument != null) {
                System.out.println("\u001B[95m'use'\u001B[0m does not have any argument, please try again.");
            } else {
                if (player.getItem() == null) {
                    System.out.println("you are not currently holding any item.");
                } else {
                    ItemType item = player.getItem();
                    player.setHp(player.getHp() + item.getDamage());
                    System.out.printf("eating \u001B[94m%s\u001B[0m\n", item.getItemName());
                    System.out.println("\u001B[92m-healing\u001B[0m");
                    System.out.println("hp: " + player.getHp());
                    player.setItem(null);
                }
            }
        } else {
            System.out.println("this command only available while playing game. \n" +
                    "please enter the game by typing \u001B[95m'play'\u001B[0m followed by the map you want to play.");
        }
    }
}
