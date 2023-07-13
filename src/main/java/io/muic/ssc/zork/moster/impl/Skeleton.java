package io.muic.ssc.zork.moster.impl;

import io.muic.ssc.zork.moster.Monster;

public class Skeleton extends Monster {
    int SKELETON_ATTACK_POWER = 8;
    int SKELETON_HP = 20;
    int SKELETON_MAX_HP = 20;

    public Skeleton(String name, String description) {
        this.setMonsName(name);
        this.setMonsDescription(description);
        this.setAttackPower(SKELETON_ATTACK_POWER);
        this.setMonsHp(SKELETON_HP);
        this.setMAX_MONS_HP(SKELETON_MAX_HP);
    }
}
