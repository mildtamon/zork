package io.muic.ssc.zork.moster.impl;

import io.muic.ssc.zork.moster.Monster;

public class Slime extends Monster {
    int SLIME_ATTACK_POWER = 2;
    int SLIME_HP = 5;
    int SLIME_MAX_HP = 5;

    public Slime(String name, String description) {
        this.setMonsName(name);
        this.setMonsDescription(description);
        this.setAttackPower(SLIME_ATTACK_POWER);
        this.setMonsHp(SLIME_HP);
        this.setMAX_MONS_HP(SLIME_MAX_HP);
    }
}
