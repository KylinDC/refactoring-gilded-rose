package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        updateShelfLife();
        updateQualityByName();
    }

    private void updateShelfLife() {
        Arrays.stream(items).forEach(Item::updateShelfLife);
    }

    private void updateQualityByName() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    item.quality = item.quality < 50 ? item.quality + 1 : item.quality;
                    item.quality = (item.quality < 50 && item.shelfLife < 0) ? item.quality + 1 : item.quality;
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                        item.quality = item.shelfLife < 12 ? item.quality + 1 : item.quality;
                        item.quality = item.shelfLife < 7 ? item.quality + 1 : item.quality;
                        item.quality = Math.min(50, item.quality);
                    }
                    item.quality = item.shelfLife < 0 ? 0 : item.quality;
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    item.quality = item.quality > 0 ? item.quality - 1 : item.quality;
                    item.quality = (item.quality > 0 && item.shelfLife < 0) ? item.quality - 1 : item.quality;
            }
        }
    }
}
