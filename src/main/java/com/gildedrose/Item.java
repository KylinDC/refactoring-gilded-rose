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

    public void updateShelfLife() {
        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            shelfLife--;
        }
    }

    public void updateQualityByName() {
        switch (name) {
            case "Aged Brie":
                quality = quality < 50 ? quality + 1 : quality;
                quality = (quality < 50 && shelfLife < 0) ? quality + 1 : quality;
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (quality < 50) {
                    quality = quality + 1;
                    quality = shelfLife < 12 ? quality + 1 : quality;
                    quality = shelfLife < 7 ? quality + 1 : quality;
                    quality = Math.min(50, quality);
                }
                quality = shelfLife < 0 ? 0 : quality;
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                quality = quality > 0 ? quality - 1 : quality;
                quality = (quality > 0 && shelfLife < 0) ? quality - 1 : quality;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.shelfLife + ", " + this.quality;
    }
}
