package com.ianbrandt.kata.gildedrose.cor

import com.ianbrandt.cor.BaseHandler
import com.ianbrandt.cor.Handler
import com.ianbrandt.kata.gildedrose.Item
import com.ianbrandt.kata.gildedrose.Items.CONJURED_ITEM
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.decreaseExpiredQuality
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.decreaseQuality
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.decreaseSellIn

internal class ConjuredItemHandler(
		nextHandler: Handler<Item>? = null
) : BaseHandler<Item>(nextHandler) {

	override fun canHandle(item: Item) = item.name == CONJURED_ITEM

	override fun doHandle(item: Item) {
		decreaseQuality(item)
		decreaseQuality(item)
		decreaseSellIn(item)
		decreaseExpiredQuality(item)
	}
}
