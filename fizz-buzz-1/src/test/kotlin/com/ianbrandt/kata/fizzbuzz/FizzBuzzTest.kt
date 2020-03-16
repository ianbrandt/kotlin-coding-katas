package com.ianbrandt.kata.fizzbuzz

import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class FizzBuzzTest {

	@TestFactory
	fun testFizzBuzzOf() = listOf(
			1 to "1",
			2 to "2",
			3 to "fizz",
			4 to "4",
			5 to "buzz",
			6 to "fizz",
			7 to "7",
			7 to "7",
			8 to "8",
			9 to "fizz",
			10 to "buzz",
			15 to "fizzbuzz",
			30 to "fizzbuzz",
			99 to "fizz",
			100 to "buzz").map { (input, expected) ->
		dynamicTest("fizzBuzzOf($input) is \"$expected\"") {
			assertThat(fizzBuzzOf(input)).isEqualTo(expected)
		}
	}

	@Test
	fun `test fizzBuzz1To100() prints 100 times`() {

		val mockPrintLn = mockk<(String) -> Unit>()

		fizzBuzz1to100(mockPrintLn)

		verify(exactly = 100) {
			mockPrintLn(any())
		}
	}
}
