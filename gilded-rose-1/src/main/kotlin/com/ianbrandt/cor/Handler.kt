package com.ianbrandt.cor

interface Handler<in T> {
	fun handle(item: T)
}
