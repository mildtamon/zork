package io.muic.ssc.zork.item;

public enum ItemType {
    WOODENSWORD(Weapon.class, "wooden sword", 3),
    IRONSWORD(Weapon.class, "iron sword", 5),
    POTION(Healing.class, "healing potion", 10);
//    STICK(Weapon.class, "wooden stick", 1),;

    private Class<? extends Item> itemClass;
    private String itemName;
    private int damage;

    ItemType(Class<? extends Item> itemClass, String itemName, int damage) {
        this.itemClass = itemClass;
        this.itemName = itemName;
        this.damage = damage;
    }

    public Class<? extends Item> getItemClass() {
        return itemClass;
    }

    public void setItemClass(Class<? extends Item> itemClass) {
        this.itemClass = itemClass;
    }

    public String getItemName() {
        return itemName;
    }

    public int getDamage() {
        return damage;
    }
}
