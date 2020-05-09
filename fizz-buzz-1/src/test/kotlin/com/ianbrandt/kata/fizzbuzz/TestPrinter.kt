package com.ianbrandt.kata.fizzbuzz

class TestPrinter : Printer {

	val prints = mutableListOf<String>()

	override fun print(fizzBuzz: String) {
		prints.add(fizzBuzz)
	}
}
