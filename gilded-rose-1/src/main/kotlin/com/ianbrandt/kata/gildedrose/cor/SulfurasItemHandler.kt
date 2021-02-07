package com.ianbrandt.kata.gildedrose.cor

import com.ianbrandt.cor.BaseHandler
import com.ianbrandt.cor.Handler
import com.ianbrandt.kata.gildedrose.Item
import com.ianbrandt.kata.gildedrose.Items.SULFURAS

internal class SulfurasItemHandler(
		nextHandler: Handler<Item>? = null
) : BaseHandler<Item>(nextHandler) {

	override fun canHandle(item: Item) = item.name == SULFURAS

	override fun doHandle(item: Item) {
		// no-op
	}
}
