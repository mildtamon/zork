package io.muic.ssc.zork.moster.impl;

import io.muic.ssc.zork.moster.Monster;

public class Zombie extends Monster {
    int ZOMBIE_ATTACK_POWER = 3;
    int ZOMBIR_HP = 10;
    int ZOMBIE_MAX_HP = 10;

    public Zombie(String name, String description) {
        this.setMonsName(name);
        this.setMonsDescription(description);
        this.setAttackPower(ZOMBIE_ATTACK_POWER);
        this.setMonsHp(ZOMBIR_HP);
        this.setMAX_MONS_HP(ZOMBIE_MAX_HP);
    }
}
