package com.saishaddai.blackbox
/**
 * Challenge:
 *
 * Write a function findFirstDuplicate that takes a list of integers as input and returns the first duplicate element in the list. If no duplicates are found, return -1.
 *
 * Example:
 *
 * Input: [2, 1, 3, 5, 3, 2] Output: 3
 *
 * Input: [1, 2, 3, 4, 5] Output: -1
 *
 * Constraints:
 *
 * The input list may contain up to 10,000 elements.
 * The elements in the list are integers between 1 and 10,000 (inclusive).
 */
object RepeatedElements {

    /**
     * finds the firs duplicated item in a list of numbers
     * @param numbers a list of numbers
     * @return the duplicated number or -1 of not duplicated found
     */
    fun findFirstDuplicate(numbers: List<Int>?) : Int {
        val seenNumbers = mutableSetOf<Int>()
        numbers?.forEach { number ->
            if (number in seenNumbers) return number
            seenNumbers.add(number)
        }
        return -1
    }

}