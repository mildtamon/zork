package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.moster.MonsterType;

import static io.muic.ssc.zork.Game.player;

public class AttackCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("'attack with' does not have any argument, please try again");
        } else {
            if (player.getCurrentRoom().getMonster() == null) {
                System.out.println("this room doesn't have any monster!");
            } else {
                MonsterType currentMonster = player.getCurrentRoom().getMonster();
                System.out.println("attacking " + currentMonster.getMonsterName());
                currentMonster.setMonsHp(currentMonster.getMonsHp() - player.getAttackPower());
                System.out.println(currentMonster.getMonsHp());
                if (!currentMonster.isAlive()) {
                    System.out.println("the monster is dead");
                    player.getCurrentRoom().setMonster(null);
                }
            }
        }
    }
}
