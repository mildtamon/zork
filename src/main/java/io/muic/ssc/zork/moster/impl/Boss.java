package io.muic.ssc.zork.moster.impl;

import io.muic.ssc.zork.moster.Monster;

public class Boss extends Monster {
    int BOSS_ATTACK_POWER = 3;
    int BOSS_HP = 10;
    int BOSS_MAX_HP = 10;

    public Boss(String name, String description, int attackPower, int hp) {
        this.setMonsName(name);
        this.setMonsDescription(description);
        this.setAttackPower(BOSS_ATTACK_POWER);
        this.setMonsHp(BOSS_HP);
        this.setMAX_MONS_HP(BOSS_MAX_HP);
    }
}
