package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        updateSellIn();

        for (Item value : items) {
            if (!value.name.equals("Aged Brie")
                    && !value.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (value.quality > 0) {
                    if (!value.name.equals("Sulfuras, Hand of Ragnaros")) {
                        value.quality = value.quality - 1;
                    }
                }
            } else {
                if (value.quality < 50) {
                    value.quality = value.quality + 1;

                    if (value.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (value.shelfLife < 12) {
                            if (value.quality < 50) {
                                value.quality = value.quality + 1;
                            }
                        }

                        if (value.shelfLife < 7) {
                            if (value.quality < 50) {
                                value.quality = value.quality + 1;
                            }
                        }
                    }
                }
            }
        }

        updateQualityWhenSellInUnderZero();

    }

    private void updateSellIn() {
        Arrays.stream(items)
                .filter(item -> !item.name.equals("Sulfuras, Hand of Ragnaros"))
                .forEach(item -> item.shelfLife--);
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
