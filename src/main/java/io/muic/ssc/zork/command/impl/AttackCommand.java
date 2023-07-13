package io.muic.ssc.zork.command.impl;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.moster.Monster;
import io.muic.ssc.zork.command.Command;
import static io.muic.ssc.zork.Game.player;
import static io.muic.ssc.zork.Game.currentMap;


public class AttackCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (currentMap != null) {
            if (argument != null) {
                System.out.println("\u001B[95m'attack with'\u001B[0m does not have any argument, please try again.");
            } else {
                if (player.getCurrentRoom().getMonster() == null) {
                    System.out.println("this room doesn't have any monster!");
                } else {
                    Monster currentMonster = player.getCurrentRoom().getMonster();
                    System.out.printf("\u001B[91m-attacking\u001B[0m %s\n", currentMonster.getMonsName());
                    currentMonster.setMonsHp(currentMonster.getMonsHp() - player.getAttackPower());
                    if (currentMonster.isAlive()) {
                        System.out.printf("monster status: [\u001B[91m%d\u001B[0m/%d]\n", currentMonster.getMonsHp(), currentMonster.getMAX_MONS_HP());
                        player.setHp(player.getHp() - currentMonster.getAttackPower());
                        System.out.printf("Ouch! you got hit! \ncurrent hp: [\u001B[91m%s\u001B[0m/%s]\n", player.getHp(), player.getMAxHp());
                    } else {
                        System.out.println("the monster is dead");
                        player.getCurrentRoom().setMonster(null);
                    }
                }
            }
        } else {
            System.out.println("this command only available while playing game. \n" +
                    "please enter the game by typing \u001B[95m'play'\u001B[0m followed by the map you want to play.");
        }
    }
}
