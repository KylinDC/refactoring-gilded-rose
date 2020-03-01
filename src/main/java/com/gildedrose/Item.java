package com.gildedrose;

public class Item {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    private String name;
    private int shelfLife;
    private int quality;

    public Item(String name, int shelfLife, int quality) {
        this.name = name;
        this.shelfLife = shelfLife;
        this.quality = quality;
    }

    public void updateShelfLife() {
        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            shelfLife--;
        }
    }

    public void updateQualityByName() {
        switch (name) {
            case "Aged Brie":
                quality = quality < MAX_QUALITY ? quality + 1 : quality;
                quality = (quality < MAX_QUALITY && shelfLife < 0) ? quality + 1 : quality;
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (quality < MAX_QUALITY) {
                    quality = quality + 1;
                    quality = shelfLife < 12 ? quality + 1 : quality;
                    quality = shelfLife < 7 ? quality + 1 : quality;
                    quality = Math.min(MAX_QUALITY, quality);
                }
                quality = shelfLife < 0 ? MIN_QUALITY : quality;
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                quality = quality > MIN_QUALITY ? quality - 1 : quality;
                quality = (quality > MIN_QUALITY && shelfLife < 0) ? quality - 1 : quality;
        }
    }

    public String getName() {
        return name;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public int getQuality() {
        return quality;
    }

    public String printItem() {
        return this.name + ", " + this.shelfLife + ", " + this.quality;
    }
}
