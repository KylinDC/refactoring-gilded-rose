package com.gildedrose;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.getItems()[0].getName());
        assertThat(app.getItems()[0].getQuality(), is(4));
        assertThat(app.getItems()[0].getShelfLife(), is(0));
    }

    @Test
    public void more_gilded_rose_item_test() {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose gildedRose = new GildedRose(items);

        String initPrint = Arrays.stream(items).map(Item::toString).reduce(String::concat).get();
        String exceptedInitPrint = "+5 Dexterity Vest, 10, 20Aged Brie, 2, 0Elixir of the Mongoose, 5, 7Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 15, 20Backstage passes to a TAFKAL80ETC concert, 10, 49Backstage passes to a TAFKAL80ETC concert, 5, 49Backstage passes to a TAFKAL80ETC concert, 1, 20Conjured Mana Cake, 3, 6";

        assertEquals(exceptedInitPrint, initPrint);

        gildedRose.updateQuality();

        String firstDayPrint = Arrays.stream(items).map(Item::toString).reduce(String::concat).get();

        String exceptedFirstDayPrint = "+5 Dexterity Vest, 9, 19Aged Brie, 1, 1Elixir of the Mongoose, 4, 6Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 14, 21Backstage passes to a TAFKAL80ETC concert, 9, 50Backstage passes to a TAFKAL80ETC concert, 4, 50Backstage passes to a TAFKAL80ETC concert, 0, 23Conjured Mana Cake, 2, 5";

        assertEquals(exceptedFirstDayPrint, firstDayPrint);

        gildedRose.updateQuality();

        String secondDayPrint = Arrays.stream(items).map(Item::toString).reduce(String::concat).get();

        String exceptedSecondDayPrint = "+5 Dexterity Vest, 8, 18Aged Brie, 0, 2Elixir of the Mongoose, 3, 5Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 13, 22Backstage passes to a TAFKAL80ETC concert, 8, 50Backstage passes to a TAFKAL80ETC concert, 3, 50Backstage passes to a TAFKAL80ETC concert, -1, 0Conjured Mana Cake, 1, 4";

        assertEquals(exceptedSecondDayPrint, secondDayPrint);

        gildedRose.updateQuality();

        String thirdDayPrint = Arrays.stream(items).map(Item::toString).reduce(String::concat).get();

        String exceptedThirdDayPrint = "+5 Dexterity Vest, 7, 17Aged Brie, -1, 4Elixir of the Mongoose, 2, 4Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 12, 23Backstage passes to a TAFKAL80ETC concert, 7, 50Backstage passes to a TAFKAL80ETC concert, 2, 50Backstage passes to a TAFKAL80ETC concert, -2, 0Conjured Mana Cake, 0, 3";

        assertEquals(exceptedThirdDayPrint, thirdDayPrint);
    }

}
