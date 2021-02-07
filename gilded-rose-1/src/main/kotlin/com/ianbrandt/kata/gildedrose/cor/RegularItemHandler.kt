package com.ianbrandt.kata.gildedrose.cor

import com.ianbrandt.cor.BaseHandler
import com.ianbrandt.cor.Handler
import com.ianbrandt.kata.gildedrose.Item
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.decreaseExpiredQuality
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.decreaseQuality
import com.ianbrandt.kata.gildedrose.cor.ItemHandlerUtils.decreaseSellIn

internal class RegularItemHandler(
		nextHandler: Handler<Item>? = null
) : BaseHandler<Item>(nextHandler) {

	override fun canHandle(item: Item) = true

	override fun doHandle(item: Item) {
		decreaseQuality(item)
		decreaseSellIn(item)
		decreaseExpiredQuality(item)
	}
}
