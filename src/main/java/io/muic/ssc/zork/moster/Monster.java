package io.muic.ssc.zork.moster;

public class Monster {
    int attackPower;
    int monsHp;
    int MAX_MONS_HP;
    boolean alive;
    String name;
    String monsDescription;

    public int getAttackPower() {
        return attackPower;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isAlive() {
        return this.monsHp > 0;
    }
    public void setDead() {
        this.alive = false;
    }

    public int getMonsHp() {
        return monsHp;
    }
    public void setMonsHp(int monsHp) {
        this.monsHp = monsHp;
    }
    public int getMAX_MONS_HP() {
        return MAX_MONS_HP;
    }
    public void setMAX_MONS_HP(int MAX_MONS_HP) {
        this.MAX_MONS_HP = MAX_MONS_HP;
    }

    public String getMonsName() {
        return name;
    }
    public void setMonsName(String name) {
        this.name = name;
    }

    public String getMonsDescription() {
        return monsDescription;
    }
    public void setMonsDescription(String monsDescription) {
        this.monsDescription = monsDescription;
    }
}
