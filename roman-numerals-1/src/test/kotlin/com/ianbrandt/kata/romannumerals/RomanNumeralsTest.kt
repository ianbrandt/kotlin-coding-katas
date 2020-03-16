package com.ianbrandt.kata.romannumerals

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class RomanNumeralsTest {

	@TestFactory
	fun testInvalidRomanNumeralConversion() = listOf(
			-1,
			0,
			4000,
			4001).map { arabicNumeral ->
		dynamicTest("$arabicNumeral.toRomanNumeral() throws IllegalArgumentException") {
			assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
				arabicNumeral.toRomanNumeral()
			}
		}
	}

	@TestFactory
	fun testRomanNumeralConversion() = listOf(
			1 to "I",
			2 to "II",
			3 to "III",
			4 to "IV",
			5 to "V",
			6 to "VI",
			7 to "VII",
			8 to "VIII",
			9 to "IX",
			10 to "X",
			11 to "XI",
			12 to "XII",
			13 to "XIII",
			14 to "XIV",
			19 to "XIX",
			20 to "XX",
			30 to "XXX",
			40 to "XL",
			50 to "L",
			60 to "LX",
			70 to "LXX",
			80 to "LXXX",
			90 to "XC",
			100 to "C",
			200 to "CC",
			300 to "CCC",
			400 to "CD",
			500 to "D",
			600 to "DC",
			700 to "DCC",
			800 to "DCCC",
			900 to "CM",
			1000 to "M",
			1999 to "MCMXCIX",
			2000 to "MM",
			3000 to "MMM",
			3500 to "MMMD",
			3999 to "MMMCMXCIX").map { (arabicNumeral, expectedRomanNumeral) ->
		dynamicTest("$arabicNumeral.toRomanNumeral() is \"$expectedRomanNumeral\"") {
			assertThat(arabicNumeral.toRomanNumeral()).isEqualTo(expectedRomanNumeral)
		}
	}
}
