package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(Item::updateShelfLife);
        Arrays.stream(items).forEach(Item::updateQualityByName);
    }

    public Item[] getItems() {
        return items;
    }
}
