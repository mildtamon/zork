package io.muic.ssc.zork.moster.impl;

import io.muic.ssc.zork.moster.Monster;

public class Zombie extends Monster {
    int ZOMBIE_ATTACK_POWER = 4;
    int ZOMBIE_HP = 10;
    int ZOMBIE_MAX_HP = 10;

    public Zombie(String name, String description) {
        this.setMonsName(name);
        this.setMonsDescription(description);
        this.setAttackPower(ZOMBIE_ATTACK_POWER);
        this.setMonsHp(ZOMBIE_HP);
        this.setMAX_MONS_HP(ZOMBIE_MAX_HP);
    }
}
