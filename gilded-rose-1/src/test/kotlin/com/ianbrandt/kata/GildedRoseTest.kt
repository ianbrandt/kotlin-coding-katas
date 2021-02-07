package com.ianbrandt.kata

import com.ianbrandt.kata.GildedRose.Companion.AGED_BRIE
import com.ianbrandt.kata.GildedRose.Companion.BACKSTAGE_PASSES
import com.ianbrandt.kata.GildedRose.Companion.CONJURED_ITEM
import com.ianbrandt.kata.GildedRose.Companion.SULFURAS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class GildedRoseTest {

	companion object {
		const val REGULAR_ITEM = "Regular Item"
	}

	@TestFactory
	fun `test Gilded Rose`(): List<DynamicTest> = listOf(
			GildedRoseTestCase(
					name = "test Sulfurus never changes",
					initialItem = Item(name = SULFURAS, sellIn = 5, quality = 80),
					expectedItem = Item(name = SULFURAS, sellIn = 5, quality = 80)),
			GildedRoseTestCase(
					name = "test Sulfurus never changes when sell by date is 1",
					initialItem = Item(name = SULFURAS, sellIn = 1, quality = 80),
					expectedItem = Item(name = SULFURAS, sellIn = 1, quality = 80)),
			GildedRoseTestCase(
					name = "test Sulfurus never changes when sell by date is 0",
					initialItem = Item(name = SULFURAS, sellIn = 0, quality = 80),
					expectedItem = Item(name = SULFURAS, sellIn = 0, quality = 80)),
			GildedRoseTestCase(
					name = "test regular items decrease in quality and sell by date",
					initialItem = Item(name = REGULAR_ITEM, sellIn = 5, quality = 25),
					expectedItem = Item(name = REGULAR_ITEM, sellIn = 4, quality = 24)),
			GildedRoseTestCase(
					name = "test regular items decrease in quality and sell by date on last day",
					initialItem = Item(name = REGULAR_ITEM, sellIn = 1, quality = 25),
					expectedItem = Item(name = REGULAR_ITEM, sellIn = 0, quality = 24)),
			GildedRoseTestCase(
					name = "test regular items decrease in quality twice as fast after sell by date",
					initialItem = Item(name = REGULAR_ITEM, sellIn = 0, quality = 25),
					expectedItem = Item(name = REGULAR_ITEM, sellIn = -1, quality = 23)),
			GildedRoseTestCase(
					name = "test regular item quality is never negative",
					initialItem = Item(name = REGULAR_ITEM, sellIn = 5, quality = 0),
					expectedItem = Item(name = REGULAR_ITEM, sellIn = 4, quality = 0)),
			GildedRoseTestCase(
					name = "test regular item quality is not negative after last day",
					initialItem = Item(name = REGULAR_ITEM, sellIn = 0, quality = 0),
					expectedItem = Item(name = REGULAR_ITEM, sellIn = -1, quality = 0)),
			GildedRoseTestCase(
					name = "test Aged Brie increases in quality",
					initialItem = Item(name = AGED_BRIE, sellIn = 11, quality = 0),
					expectedItem = Item(name = AGED_BRIE, sellIn = 10, quality = 1)),
			GildedRoseTestCase(
					name = "test Aged Brie increases 2 in quality after sell by date",
					initialItem = Item(name = AGED_BRIE, sellIn = 0, quality = 0),
					expectedItem = Item(name = AGED_BRIE, sellIn = -1, quality = 2)),
			GildedRoseTestCase(
					name = "test Aged Brie quality max is 50",
					initialItem = Item(name = AGED_BRIE, sellIn = 25, quality = 50),
					expectedItem = Item(name = AGED_BRIE, sellIn = 24, quality = 50)),
			GildedRoseTestCase(
					name = "test Backstage Passes increase in quality",
					initialItem = Item(name = BACKSTAGE_PASSES, sellIn = 11, quality = 0),
					expectedItem = Item(name = BACKSTAGE_PASSES, sellIn = 10, quality = 1)),
			GildedRoseTestCase(
					name = "test Backstage Passes quality max is 50",
					initialItem = Item(name = BACKSTAGE_PASSES, sellIn = 25, quality = 50),
					expectedItem = Item(name = BACKSTAGE_PASSES, sellIn = 24, quality = 50)),
			GildedRoseTestCase(
					name = "test Backstage Passes increase 2 in quality with 10 days or less",
					initialItem = Item(name = BACKSTAGE_PASSES, sellIn = 10, quality = 0),
					expectedItem = Item(name = BACKSTAGE_PASSES, sellIn = 9, quality = 2)),
			GildedRoseTestCase(
					name = "test Backstage Passes increase 3 in quality with 5 days or less",
					initialItem = Item(name = BACKSTAGE_PASSES, sellIn = 5, quality = 0),
					expectedItem = Item(name = BACKSTAGE_PASSES, sellIn = 4, quality = 3)),
			GildedRoseTestCase(
					name = "test Backstage Passes quality goes to zero after the concert",
					initialItem = Item(name = BACKSTAGE_PASSES, sellIn = 0, quality = 10),
					expectedItem = Item(name = BACKSTAGE_PASSES, sellIn = -1, quality = 0)),
			GildedRoseTestCase(
					name = "test Backstage Passes quality max is 50",
					initialItem = Item(name = BACKSTAGE_PASSES, sellIn = 1, quality = 49),
					expectedItem = Item(name = BACKSTAGE_PASSES, sellIn = 0, quality = 50)),
			GildedRoseTestCase(
					name = "test Conjured item quality decreases twice as fast as regular items",
					initialItem = Item(name = CONJURED_ITEM, sellIn = 1, quality = 50),
					expectedItem = Item(name = CONJURED_ITEM, sellIn = 0, quality = 48)),
	).map { testCase ->
		with(testCase) {
			dynamicTest(name) {
				val items = arrayOf(initialItem)
				val gildedRose = GildedRose(items)

				gildedRose.updateQuality()

				assertThat(items[0]).isEqualTo(expectedItem)
			}
		}
	}
}

internal data class GildedRoseTestCase(
		val name: String,
		val initialItem: Item,
		val expectedItem: Item
)
