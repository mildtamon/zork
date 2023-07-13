package io.muic.ssc.zork.moster.impl;

import io.muic.ssc.zork.moster.Monster;

public class Boss extends Monster {
//    int BOSS_ATTACK_POWER = 10;
//    int BOSS_HP = 30;
//    int BOSS_MAX_HP = 30;

    // boss in each map doesn't have same hp
    public Boss(String name, String description, int attackingPower, int hp) {
        this.setMonsName(name);
        this.setMonsDescription(description);
        this.setAttackPower(attackingPower);
        this.setMonsHp(hp);
        this.setMAX_MONS_HP(hp);
    }
}
