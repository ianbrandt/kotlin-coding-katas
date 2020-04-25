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
			3 to "Fizz",
			4 to "4",
			5 to "Buzz",
			6 to "Fizz",
			7 to "7",
			7 to "7",
			8 to "8",
			9 to "Fizz",
			10 to "Buzz",
			15 to "FizzBuzz",
			30 to "FizzBuzz",
			99 to "Fizz",
			100 to "Buzz").map { (input, expected) ->
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
