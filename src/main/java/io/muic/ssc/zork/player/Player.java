package io.muic.ssc.zork.player;

import io.muic.ssc.zork.room.Room;

public class Player {

    private final int MAX_HP = 50;

    private int hp;
    private int attackPower;
    private String item;

    public static Room currentRoom;

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPower() {
        return attackPower;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }

    // constructor
    public Player() {
        setHp(50);
        setAttackPower(1);
        setItem(null);
    }

    public String playerInfo() {
        return String.format("""
                          * current hp: %d/%d\s
                          * player is holding: %s\s
                          * attack power: %d""", getHp(), MAX_HP, getItem(), getAttackPower());
    }
}
