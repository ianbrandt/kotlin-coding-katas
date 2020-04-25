package com.ianbrandt.kata.fizzbuzz

fun main() = fizzBuzz1to100(::println)

internal fun fizzBuzzOf(n: Int): String {
	if (n % 15 == 0) return "FizzBuzz"
	if (n % 5 == 0) return "Buzz"
	if (n % 3 == 0) return "Fizz"
	return n.toString()
}

internal fun fizzBuzz1to100(printFunction: (String) -> Unit) {
	(1..100).forEach { printFunction(fizzBuzzOf(it)) }
}
