package com.ianbrandt.kata.romannumerals

fun Int.toRomanNumeral(): String {

	if (this < 1 || this >= 4000) throw IllegalArgumentException("No valid Roman numeral for $this")

	val i = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
	val x = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
	val c = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
	val m = arrayOf("", "M", "MM", "MMM")

	return m[this / 1000] +
			c[this % 1000 / 100] +
			x[this % 100 / 10] +
			i[this % 10]
}
