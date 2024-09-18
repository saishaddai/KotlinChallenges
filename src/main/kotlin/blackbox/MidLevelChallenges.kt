package com.saishaddai.blackbox

import kotlin.math.abs

object MidLevelChallenges {

    /**
     * Write a function findClosestPair that takes a list of integers as input
     * and returns the pair of integers that have the smallest absolute
     * difference. If there are multiple pairs with the same smallest
     * difference, return any one of them.
     *
     * Example:
     *
     * Input: listOf(5, 2, 8, 12, 3) Output: (2, 3) (because 2 and 3 have the smallest absolute difference of 1)
     *               (2, 3, 5, 8, 12)
     *               (1, 2, 3, 4)
     * Constraints:
     *
     * The input list may contain duplicates.
     * The input list may be empty, in which case the function should return an empty list.
     * The input list may contain only one element, in which case the function should return an empty list.
     *
     */
    fun findClosestPair(numbers: List<Int>) : List<Int> {
        if(numbers.isEmpty() || numbers.size == 1) return listOf()
        var minDistance = Int.MAX_VALUE
        var minList =  emptyList<Int>()
        val sorted = numbers.sorted()

        for(i in 0 until sorted.size - 1) {
            if (sorted[i] != sorted[i+1]) {
                val diff = abs(sorted[i+1] - sorted[i])
                if(minDistance > diff) {
                    minDistance = diff
                    minList = listOf(sorted[i] , sorted[i+1])
                }
            }
        }
        return minList
    }


    fun findClosestPair2(numbers: List<Int>) : Pair<Int, Int>? {
        if (numbers.size == 1 || numbers.isEmpty()) return null
        var minDiff = Int.MAX_VALUE
        var closestPair = Pair(0, 0)
        val sortedList = numbers.sorted()
        for (i in 0 until sortedList.size - 1) {
            val diff = abs(sortedList[i] - sortedList[i+1])
            if (diff < minDiff) {
                minDiff = diff
                closestPair =  sortedList[i] to sortedList[i+1]
            }
        }
        return if (minDiff == Int.MAX_VALUE) null else closestPair
    }

}