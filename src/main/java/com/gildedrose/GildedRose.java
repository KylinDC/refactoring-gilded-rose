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
        Arrays.stream(items).forEach(Item::updateQualityByName);
    }
}
