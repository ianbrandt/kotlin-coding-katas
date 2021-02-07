package com.ianbrandt.cor

abstract class BaseHandler<in T>(private val nextHandler: Handler<T>? = null) : Handler<T> {

	protected abstract fun canHandle(item: T): Boolean

	protected abstract fun doHandle(item: T)

	override fun handle(item: T) {
		if (canHandle(item)) {
			doHandle(item)
		} else {
			nextHandler?.handle(item) ?: throw IllegalArgumentException("Unhandled item $item")
		}
	}
}
