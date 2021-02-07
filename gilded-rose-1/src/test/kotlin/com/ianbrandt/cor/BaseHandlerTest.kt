package com.ianbrandt.cor

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

internal class BaseHandlerTest {

	@Test
	internal fun `test handler for can handle`() {

		val handler = TestHandler<String>()

		handler.handle("Testing")

		assertThat(handler.handled).isTrue
	}

	@Test
	internal fun `test handler for can't handle`() {

		val handler = TestHandler<String>(canHandle = false)

		assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
			handler.handle("Testing")
		}
	}

	@Test
	internal fun `test next handler for can handle`() {

		val nextHandler = TestHandler<String>()

		val handler = TestHandler(canHandle = false, nextHandler)

		handler.handle("Testing")

		assertThat(handler.handled).isFalse
		assertThat(nextHandler.handled).isTrue
	}
}
