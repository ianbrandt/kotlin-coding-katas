package com.ianbrandt.cor

internal class TestHandler<T>(
		private val canHandle: Boolean = true,
		nextHandler: Handler<T>? = null,
) : BaseHandler<T>(nextHandler) {

	var handled = false

	override fun canHandle(item: T) = canHandle

	override fun doHandle(item: T) {
		handled = true
	}
}
