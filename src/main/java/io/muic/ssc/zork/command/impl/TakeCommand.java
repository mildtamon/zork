package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.item.Weapon;
import io.muic.ssc.zork.item.ItemType;
import io.muic.ssc.zork.command.Command;
import static io.muic.ssc.zork.Game.player;
import static io.muic.ssc.zork.Game.currentMap;

public class TakeCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (currentMap != null) {
            if (argument != null) {
                System.out.println("\u001B[95m'take'\u001B[0m does not have any argument, please try again.");
            } else {
                ItemType itemType = player.currentRoom.getItem();
                if (itemType == null) {
                    System.out.println("this room has no item!");
                } else {
                    // if there is monster in the room, must kill it first before getting the item.
                    if (player.getCurrentRoom().getMonster() != null) {
                        System.out.println("the monster is blocking the way! you must kill it first!");
                    } else {
                        System.out.printf("taking \u001B[94m%s\u001B[0m!\n", itemType.getItemName());

                        // if the item is weapon -> weapon slot, else -> healing slot won't swap item.
                        if (itemType.getItemClass() == Weapon.class) {

                            // if the slot is occupied, swap item and drop in the current room
                            if (player.getWeapon() != null) {
                                System.out.printf("--swapping \u001B[94m%s\u001B[0m with \u001B[94m%s\u001B[0m\n", player.getWeapon().getItemName(), itemType.getItemName());
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
        } else {
            System.out.println("this command only available while playing game. \n" +
                    "please enter the game by typing \u001B[95m'play'\u001B[0m followed by the map you want to play.");
        }
    }
}
