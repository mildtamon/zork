package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.item.ItemType;
import io.muic.ssc.zork.item.Weapon;

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
                // if there is monster in the room, must kill it first before getting the item.
                if (player.getCurrentRoom().getMonster() != null) {
                    System.out.println("the monster is blocking the way! you must kill it first!");
                } else {
                    System.out.printf("taking %s!\n", itemType.getItemName());

                    // if the item is weapon -> weapon slot
                    if (itemType.getItemClass() == Weapon.class) {

                        // if the slot is occupied, swap item and drop in the current room
                        if (player.getWeapon() != null) {
                            System.out.printf("--swapping %s with %s\n", player.getWeapon().getItemName(), itemType.getItemName());
                            player.currentRoom.setItem(player.getWeapon());
                        } else {
                            player.currentRoom.setItem(null);
                        }
                        player.setWeapon(itemType);
                        player.setAttackPower(itemType.getDamage());
                    } else {    // if the item is potion -> item slot
                        player.setItem(itemType);
                        player.currentRoom.setItem(null);
                    }
                }
            }
        }
    }
}
