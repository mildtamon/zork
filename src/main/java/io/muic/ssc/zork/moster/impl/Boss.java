package io.muic.ssc.zork.moster.impl;

import io.muic.ssc.zork.moster.Monster;

public class Boss extends Monster {

    public Boss(String name, String description, int attackPower, int hp) {
        this.setMonsName(name);
        this.setMonsDescription(description);
        this.setAttackPower(attackPower);
        this.setMonsHp(hp);
    }
}
