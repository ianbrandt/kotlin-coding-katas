package com.ianbrandt.kata.gildedrose.cor

import com.ianbrandt.cor.BaseHandler
import com.ianbrandt.cor.Handler
import com.ianbrandt.kata.gildedrose.Item
import com.ianbrandt.kata.gildedrose.Items.AGED_BRIE
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.decreaseSellIn
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.increaseQuality

internal class AgedBrieItemHandler(
		nextHandler: Handler<Item>? = null
) : BaseHandler<Item>(nextHandler) {

	override fun canHandle(item: Item) = item.name == AGED_BRIE

	override fun doHandle(item: Item) {
		increaseQuality(item)
		decreaseSellIn(item)
		if (item.sellIn < 0) {
			increaseQuality(item)
		}
	}
}
