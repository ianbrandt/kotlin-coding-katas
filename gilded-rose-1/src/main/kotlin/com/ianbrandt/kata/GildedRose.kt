package com.ianbrandt.kata

class GildedRose(var items: Array<Item>) {

	companion object {
		const val AGED_BRIE = "Aged Brie"
		const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
		const val CONJURED_ITEM = "Conjured"
		const val SULFURAS = "Sulfuras, Hand of Ragnaros"
		const val MAX_QUALITY = 50
	}

	fun updateQuality() {
		for (item in items) {
			updateQuality(item)
		}
	}

	private fun updateQuality(item: Item) {
		when (item.name) {
			AGED_BRIE -> {
				increaseQuality(item)
				decreaseSellIn(item)
				if (item.sellIn < 0) {
					increaseQuality(item)
				}
			}
			BACKSTAGE_PASSES -> {
				increaseQuality(item)
				if (item.sellIn < 11) {
					increaseQuality(item)
				}
				if (item.sellIn < 6) {
					increaseQuality(item)
				}
				decreaseSellIn(item)
				if (item.sellIn < 0) {
					item.quality = 0
				}
			}
			CONJURED_ITEM -> {
				decreaseQuality(item)
				decreaseQuality(item)
				decreaseSellIn(item)
				decreaseExpiredQuality(item)
			}
			SULFURAS -> return
			else -> {
				decreaseQuality(item)
				decreaseSellIn(item)
				decreaseExpiredQuality(item)
			}
		}
	}

	private fun decreaseSellIn(item: Item) {
		item.sellIn = item.sellIn - 1
	}

	private fun increaseQuality(item: Item) {
		if (item.quality < MAX_QUALITY) {
			item.quality = item.quality + 1
		}
	}

	private fun decreaseQuality(item: Item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1
		}
	}

	private fun decreaseExpiredQuality(item: Item) {
		if (item.sellIn < 0) {
			decreaseQuality(item)
		}
	}
}
