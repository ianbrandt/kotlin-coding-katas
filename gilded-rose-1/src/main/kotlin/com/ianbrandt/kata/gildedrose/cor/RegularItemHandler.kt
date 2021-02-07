package com.ianbrandt.kata.gildedrose.cor

import com.ianbrandt.cor.BaseHandler
import com.ianbrandt.kata.gildedrose.Item
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.decreaseExpiredQuality
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.decreaseQuality
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.decreaseSellIn

internal class RegularItemHandler : BaseHandler<Item>(
		// Terminal handler
		nextHandler = null
) {

	// Catch-all
	override fun canHandle(item: Item) = true

	override fun doHandle(item: Item) {
		decreaseQuality(item)
		decreaseSellIn(item)
		decreaseExpiredQuality(item)
	}
}
