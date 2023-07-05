package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.item.ItemType;

import static io.muic.ssc.zork.Game.player;

public class DropCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("'drop' does not have any argument, please try again");
        } else {
            ItemType currentItem = player.getWeapon();
            if (currentItem == null) {
                System.out.println("you are not holding any item!");
            } else {
                // dropping item != swapping, dropping item (weapon) will cause the item to disappear.
                System.out.printf("dropping %s!\n", currentItem.getItemName());
                player.setWeapon(null);
                player.setAttackPower(1);       // set to default attack power
            }
        }
    }
}
