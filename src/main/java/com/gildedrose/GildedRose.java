package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {

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
                        if (value.sell_in < 12) {
                            if (value.quality < 50) {
                                value.quality = value.quality + 1;
                            }
                        }

                        if (value.sell_in < 7) {
                            if (value.quality < 50) {
                                value.quality = value.quality + 1;
                            }
                        }
                    }
                }
            }
        }

        for (Item item : items) {
            if (item.sell_in < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    private void updateSellIn() {
        Arrays.stream(items)
                .filter(item -> !item.name.equals("Sulfuras, Hand of Ragnaros"))
                .forEach(item -> item.sell_in--);
    }
}
