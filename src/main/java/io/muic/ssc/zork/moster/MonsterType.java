//package io.muic.ssc.zork.moster;
//
//public enum MonsterType {
//    // attack power, HP, status
//    FRISTBOSS("first boss", 5, 30, "This is the first boss, kill it to finish this map."),
//    ZOMBIE("first zombie", 3, 10, "This is a zombie, hit your first monster!");
//
//    private final String monsterName;
//    private final String monsterDescription;
//    private final int attackPower;
//    private int monsHp;
//    boolean alive;
//
//
//
//    MonsterType(String monsterName, int attackPower, int monsHp, String monsterDescription) {
//        // TODO: declearconstructor.newInstance เพื่อไม่ให้เป็นตัวเดียวกัน link กัน + factory
//
//        this.monsterName = monsterName;
//        this.attackPower = attackPower;
//        this.monsHp = monsHp;
//        this.monsterDescription = monsterDescription;
//    }
//
//    public String getMonsterName() {
//        return monsterName;
//    }
//
//    public String getMonsterDescription() {
//        return monsterDescription;
//    }
//
//    public int getAttackPower() {
//        return attackPower;
//    }
//
//    public int getMonsHp() {
//        return monsHp;
//    }
//
//    public void setMonsHp(int monsHp) {
//        this.monsHp = monsHp;
//    }
//
//    public boolean isAlive() {
//        return monsHp > 0;
//    }
//    public void setDead() {
//        this.alive = this.isAlive();
//    }
//}
