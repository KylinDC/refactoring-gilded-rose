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
        updateQualityWhenSellInUnderZero();
    }

    private void updateShelfLife() {
        Arrays.stream(items)
                .filter(item -> !item.name.equals("Sulfuras, Hand of Ragnaros"))
                .forEach(item -> item.shelfLife--);
    }

    private void updateQualityByName() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    item.quality = item.quality < 50 ? item.quality + 1 : item.quality;
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                        item.quality = item.shelfLife < 12 ? item.quality + 1 : item.quality;
                        item.quality = item.shelfLife < 7 ? item.quality + 1 : item.quality;
                        item.quality = Math.min(50, item.quality);
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    item.quality = item.quality > 0 ? item.quality - 1 : item.quality;
            }
        }
    }

    private void updateQualityWhenSellInUnderZero() {
        for (Item item : items) {
            if (item.shelfLife < 0) {
                switch (item.name) {
                    case "Aged Brie":
                        item.quality = item.quality < 50 ? item.quality + 1 : item.quality;
                        break;
                    case "Backstage passes to a TAFKAL80ETC concert":
                        item.quality = 0;
                        break;
                    case "Sulfuras, Hand of Ragnaros":
                        break;
                    default:
                        item.quality = item.quality > 0 ? item.quality - 1 : item.quality;
                }
            }
        }
    }
}
