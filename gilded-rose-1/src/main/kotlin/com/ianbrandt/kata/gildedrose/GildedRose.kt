package com.ianbrandt.kata.gildedrose

import com.ianbrandt.cor.Handler
import com.ianbrandt.kata.gildedrose.cor.AgedBrieItemHandler
import com.ianbrandt.kata.gildedrose.cor.BackstagePassesItemHandler
import com.ianbrandt.kata.gildedrose.cor.ConjuredItemHandler
import com.ianbrandt.kata.gildedrose.cor.RegularItemHandler
import com.ianbrandt.kata.gildedrose.cor.SulfurasItemHandler

fun gildedRoseFactory(items: Array<Item>) = GildedRose(items, chainOfResponsibility)

class GildedRose internal constructor(
		var items: Array<Item>,
		private val chainOfResponsibility: Handler<Item>
) {
	fun updateQuality() {
		items.forEach { chainOfResponsibility.handle(it) }
	}
}

private val chainOfResponsibility: Handler<Item> =
		AgedBrieItemHandler(
				BackstagePassesItemHandler(
						ConjuredItemHandler(
								SulfurasItemHandler(
										RegularItemHandler()))))
