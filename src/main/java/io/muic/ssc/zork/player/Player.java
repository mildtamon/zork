package io.muic.ssc.zork.player;

import io.muic.ssc.zork.item.Item;
import io.muic.ssc.zork.item.ItemType;
import io.muic.ssc.zork.room.Room;

public class Player {

    // TODO: set dead to player

    private final int MAX_HP = 100;

    private int hp;
    private int attackPower;
    private ItemType item;
    private ItemType weapon;
    private boolean alive;

    public Room currentRoom;

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp > MAX_HP) {
            this.hp = MAX_HP;
        }
    }
    public int getMAxHp() {
        return MAX_HP;
    }

    public boolean isAlive() {
        return this.getHp() > 0;
    }

    public int getAttackPower() {
        return attackPower;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public ItemType getItem() {
        return item;
    }
    public void setItem(ItemType item) {
        this.item = item;
    }

    public ItemType getWeapon() {
        return weapon;
    }
    public void setWeapon(ItemType weapon) {
        this.weapon = weapon;
    }

    // constructor
    public Player() {
        setHp(100);
        setAttackPower(1);
        setItem(null);
        setWeapon(null);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String playerInfo() {
        return String.format("""
                          * current hp: \u001B[91m%d\u001B[0m/%d\s
                          * current weapon: \u001B[94m%s\u001B[0m\s
                          * current item: \u001B[94m%s\u001B[0m\s
                          * attack power: \u001B[91m%d\u001B[0m""", getHp(), MAX_HP,  ((getWeapon() == null)? getWeapon() : getWeapon().getItemName()),
                                                 ((getItem() == null)? getItem() : getItem().getItemName()), getAttackPower());
    }
}
