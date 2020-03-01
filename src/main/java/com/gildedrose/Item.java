package com.gildedrose;

public class Item {

    public String name;

    public int shelfLife;

    public int quality;

    public Item(String name, int shelfLife, int quality) {
        this.name = name;
        this.shelfLife = shelfLife;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.shelfLife + ", " + this.quality;
    }
}
