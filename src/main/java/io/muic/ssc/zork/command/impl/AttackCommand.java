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
                    // attacking
                    Monster currentMonster = player.getCurrentRoom().getMonster();
                    System.out.printf("\u001B[91m-attacking\u001B[0m %s\n", currentMonster.getMonsName());
                    currentMonster.setMonsHp(currentMonster.getMonsHp() - player.getAttackPower());

                    if (currentMonster.isAlive()) {
                        // monster alive
                        System.out.printf("monster status: [\u001B[91m%d\u001B[0m/%d]\n", currentMonster.getMonsHp(), currentMonster.getMAX_MONS_HP());
                        player.setHp(player.getHp() - currentMonster.getAttackPower());
                        System.out.println("Ouch! you got hit!");
                        if (player.isAlive()) {
                            // player alive
                            System.out.printf("current hp: [\u001B[91m%s\u001B[0m/%s]\n", player.getHp(), player.getMAxHp());
                        } else {
                            // player died
                            System.out.println("you are \u001B[91mdead\u001B[0m");
                            System.out.println("going back to \u001B[93mhome\u001B[0m.");

                            currentMap = null;
                            System.out.println("\u001B[93m > home <\u001B[0m");
                        }
                    } else {
                        // monster died
                        System.out.println("the monster is dead");
                        currentMonster.setDead();
                        player.getCurrentRoom().setMonster(null);

                        // if the boss is dead -> go home, restart the map
                        if (currentMap.isFinishedMap()) {
                            System.out.println("Congratulations! you killed the boss!");
                            System.out.println("going back to \u001B[93mhome\u001B[0m.");

                            currentMap = null;
                            System.out.println("\u001B[93m > home <\u001B[0m");
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
