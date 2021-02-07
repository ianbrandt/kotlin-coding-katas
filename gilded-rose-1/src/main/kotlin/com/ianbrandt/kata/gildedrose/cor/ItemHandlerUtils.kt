package com.ianbrandt.kata.gildedrose.cor

import com.ianbrandt.kata.gildedrose.Item

internal object ItemHandlerUtils {

	internal const val MAX_QUALITY = 50

	internal fun decreaseSellIn(item: Item) {
		item.sellIn = item.sellIn - 1
	}

	internal fun increaseQuality(item: Item) {
		if (item.quality < MAX_QUALITY) {
			item.quality = item.quality + 1
		}
	}

	internal fun decreaseQuality(item: Item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1
		}
	}

	internal fun decreaseExpiredQuality(item: Item) {
		if (item.sellIn < 0) {
			decreaseQuality(item)
		}
	}
}
