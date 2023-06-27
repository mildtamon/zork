package io.muic.ssc.zork.player;

import io.muic.ssc.zork.item.Item;
import io.muic.ssc.zork.item.ItemType;
import io.muic.ssc.zork.room.Room;

public class Player {

    private final int MAX_HP = 50;

    private int hp;
    private int attackPower;
    private ItemType item;

    public Room currentRoom;

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

    public ItemType getItem() {
        return item;
    }
    public void setItem(ItemType item) {
        this.item = item;
    }

    // constructor
    public Player() {
        setHp(50);
        setAttackPower(1);
        setItem(null);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String playerInfo() {
        return String.format("""
                          * current hp: %d/%d\s
                          * player is holding: %s\s
                          * attack power: %d""", getHp(), MAX_HP,  ((getItem() == null)? getItem() : getItem().getItemName()), getAttackPower());
    }
}
