package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.item.ItemType;

import static io.muic.ssc.zork.Game.player;

public class TakeCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("'take' does not have any argument, please try again");
        } else {
            ItemType itemType = player.currentRoom.getItem();
            if (itemType == null) {
                System.out.println("this room has no item!");
            } else {
                System.out.printf("taking %s!\n", itemType.getItemName());
                player.setItem(itemType);
                player.currentRoom.setItem(null);
                player.setAttackPower(itemType.getDamage());
            }
        }
    }
}
