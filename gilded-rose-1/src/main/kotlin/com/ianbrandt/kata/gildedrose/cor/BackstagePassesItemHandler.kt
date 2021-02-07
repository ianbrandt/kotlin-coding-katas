package com.ianbrandt.kata.gildedrose.cor

import com.ianbrandt.cor.BaseHandler
import com.ianbrandt.cor.Handler
import com.ianbrandt.kata.gildedrose.Item
import com.ianbrandt.kata.gildedrose.Items.BACKSTAGE_PASSES
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.decreaseSellIn
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.increaseQuality

internal class BackstagePassesItemHandler(
		nextHandler: Handler<Item>? = null
) : BaseHandler<Item>(nextHandler) {

	override fun canHandle(item: Item) = item.name == BACKSTAGE_PASSES

	override fun doHandle(item: Item) {
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
}
