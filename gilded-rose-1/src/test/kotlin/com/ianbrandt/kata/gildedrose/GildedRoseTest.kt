package com.ianbrandt.kata.gildedrose

import com.ianbrandt.kata.gildedrose.Items.AGED_BRIE
import com.ianbrandt.kata.gildedrose.Items.BACKSTAGE_PASSES
import com.ianbrandt.kata.gildedrose.Items.CONJURED_ITEM
import com.ianbrandt.kata.gildedrose.Items.SULFURAS
import com.ianbrandt.kata.gildedrose.Items.SULFURAS_QUALITY
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.MAX_QUALITY
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

private const val TEST_ITEM = "Regular Item"

internal class GildedRoseTest {
	@TestFactory
	fun `test Gilded Rose`(): List<DynamicTest> = listOf(
			GildedRoseTestCase(
					name = "test Sulfurus never changes",
					initial = Item(name = SULFURAS, sellIn = 5, quality = SULFURAS_QUALITY),
					expected = Item(name = SULFURAS, sellIn = 5, quality = SULFURAS_QUALITY)),
			GildedRoseTestCase(
					name = "test Sulfurus never changes when sell by date is 1",
					initial = Item(name = SULFURAS, sellIn = 1, quality = SULFURAS_QUALITY),
					expected = Item(name = SULFURAS, sellIn = 1, quality = SULFURAS_QUALITY)),
			GildedRoseTestCase(
					name = "test Sulfurus never changes when sell by date is 0",
					initial = Item(name = SULFURAS, sellIn = 0, quality = SULFURAS_QUALITY),
					expected = Item(name = SULFURAS, sellIn = 0, quality = SULFURAS_QUALITY)),
			GildedRoseTestCase(
					name = "test regular items decrease in quality and sell by date",
					initial = Item(name = TEST_ITEM, sellIn = 5, quality = 25),
					expected = Item(name = TEST_ITEM, sellIn = 4, quality = 24)),
			GildedRoseTestCase(
					name = "test regular items decrease in quality and sell by date on last day",
					initial = Item(name = TEST_ITEM, sellIn = 1, quality = 25),
					expected = Item(name = TEST_ITEM, sellIn = 0, quality = 24)),
			GildedRoseTestCase(
					name = "test regular items decrease in quality twice as fast after sell by date",
					initial = Item(name = TEST_ITEM, sellIn = 0, quality = 25),
					expected = Item(name = TEST_ITEM, sellIn = -1, quality = 23)),
			GildedRoseTestCase(
					name = "test regular item quality is never negative",
					initial = Item(name = TEST_ITEM, sellIn = 5, quality = 0),
					expected = Item(name = TEST_ITEM, sellIn = 4, quality = 0)),
			GildedRoseTestCase(
					name = "test regular item quality is not negative after last day",
					initial = Item(name = TEST_ITEM, sellIn = 0, quality = 0),
					expected = Item(name = TEST_ITEM, sellIn = -1, quality = 0)),
			GildedRoseTestCase(
					name = "test Aged Brie increases in quality",
					initial = Item(name = AGED_BRIE, sellIn = 11, quality = 0),
					expected = Item(name = AGED_BRIE, sellIn = 10, quality = 1)),
			GildedRoseTestCase(
					name = "test Aged Brie increases 2 in quality after sell by date",
					initial = Item(name = AGED_BRIE, sellIn = 0, quality = 0),
					expected = Item(name = AGED_BRIE, sellIn = -1, quality = 2)),
			GildedRoseTestCase(
					name = "test Aged Brie quality max is 50",
					initial = Item(name = AGED_BRIE, sellIn = 25, quality = MAX_QUALITY),
					expected = Item(name = AGED_BRIE, sellIn = 24, quality = MAX_QUALITY)),
			GildedRoseTestCase(
					name = "test Backstage Passes increase in quality",
					initial = Item(name = BACKSTAGE_PASSES, sellIn = 11, quality = 0),
					expected = Item(name = BACKSTAGE_PASSES, sellIn = 10, quality = 1)),
			GildedRoseTestCase(
					name = "test Backstage Passes quality max is 50",
					initial = Item(name = BACKSTAGE_PASSES, sellIn = 25, quality = MAX_QUALITY),
					expected = Item(name = BACKSTAGE_PASSES, sellIn = 24, quality = MAX_QUALITY)),
			GildedRoseTestCase(
					name = "test Backstage Passes increase 2 in quality with 10 days or less",
					initial = Item(name = BACKSTAGE_PASSES, sellIn = 10, quality = 0),
					expected = Item(name = BACKSTAGE_PASSES, sellIn = 9, quality = 2)),
			GildedRoseTestCase(
					name = "test Backstage Passes increase 3 in quality with 5 days or less",
					initial = Item(name = BACKSTAGE_PASSES, sellIn = 5, quality = 0),
					expected = Item(name = BACKSTAGE_PASSES, sellIn = 4, quality = 3)),
			GildedRoseTestCase(
					name = "test Backstage Passes quality goes to zero after the concert",
					initial = Item(name = BACKSTAGE_PASSES, sellIn = 0, quality = 10),
					expected = Item(name = BACKSTAGE_PASSES, sellIn = -1, quality = 0)),
			GildedRoseTestCase(
					name = "test Backstage Passes quality max is 50",
					initial = Item(name = BACKSTAGE_PASSES, sellIn = 1, quality = MAX_QUALITY),
					expected = Item(name = BACKSTAGE_PASSES, sellIn = 0, quality = MAX_QUALITY)),
			GildedRoseTestCase(
					name = "test Conjured item quality decreases twice as fast as regular items",
					initial = Item(name = CONJURED_ITEM, sellIn = 1, quality = MAX_QUALITY),
					expected = Item(name = CONJURED_ITEM, sellIn = 0, quality = 48)),
	).map { testCase ->
		with(testCase) {
			dynamicTest(name) {
				val items = arrayOf(initial)
				val gildedRose = gildedRoseFactory(items)

				gildedRose.updateQuality()

				assertThat(items).containsExactly(expected)
			}
		}
	}
}

private data class GildedRoseTestCase(
		val name: String,
		val initial: Item,
		val expected: Item
)
