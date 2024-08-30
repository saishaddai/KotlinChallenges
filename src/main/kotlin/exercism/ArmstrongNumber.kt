package com.saishaddai.exercism

import kotlin.math.abs
import kotlin.math.pow

/**
 * An Armstrong number is a number that is the sum of its own digits each raised to the power of the number of digits.
 *
 * For example:
 *
 * 9 is an Armstrong number, because 9 = 9^1 = 9
 * 10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 1
 * 153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
 * 154 is not an Armstrong number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190
 *
 */
object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val inputAsString = input.absString()
        val length = inputAsString.length
        return inputAsString.sumOf { d -> d.digitToInt().pow(length) } == input.toDouble().toInt()
    }

    private fun Int.absString(): String = abs(this).toString()
    private fun Int.pow(e: Int): Int = this.toDouble().pow(e.toDouble()).toInt()
}