package io.muic.ssc.zork.item;

public enum ItemType {
    // weapon
    WOODENSTICK(Weapon.class, "wooden stick", 3),
    WOODENSWORD(Weapon.class, "wooden sword", 5),
    IRONSWORD(Weapon.class, "iron sword", 8),
    DIAMONDSWORD(Weapon.class, "diamond sword", 14),

    // healing item
    POTION(Healing.class, "healing potion", 10),
    APPLE(Healing.class, "apple", 3),
    BREAD(Healing.class, "bread", 5),
    STEAK(Healing.class, "steak", 8);

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
