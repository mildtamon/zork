package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.item.Item;
import io.muic.ssc.zork.item.ItemType;
import io.muic.ssc.zork.moster.MonsterType;

import static io.muic.ssc.zork.Game.player;

public class UseCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("'use' does not have any argument, please try again");
        } else {
            if (player.getItem() == null) {
                System.out.println("you are not currently holding any item.");
            } else {
                ItemType item = player.getItem();
                player.setHp(player.getHp() + item.getDamage());
                System.out.println("using " + item.getItemName());
                player.setItem(null);
//                MonsterType currentMonster = player.getCurrentRoom().getMonster();
//                System.out.println("attacking " + currentMonster.getMonsterName());
//                currentMonster.setMonsHp(currentMonster.getMonsHp() - player.getAttackPower());
//                System.out.println(currentMonster.getMonsHp());
//                if (!currentMonster.isAlive()) {
//                    System.out.println("the monster is dead");
//                    player.getCurrentRoom().setMonster(null);
//                }
            }
        }
    }
}
