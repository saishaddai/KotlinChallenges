package blackbox

import com.saishaddai.blackbox.FilterChallenges
import com.saishaddai.blackbox.FilterChallenges.filterAndProcessList
import com.saishaddai.blackbox.FilterChallenges.calculateCartTotalCost
import com.saishaddai.blackbox.FilterChallenges.calculateFactorial
import com.saishaddai.blackbox.FilterChallenges.filterMap
import com.saishaddai.blackbox.FilterChallenges.findLongestWord
import com.saishaddai.blackbox.FilterChallenges.getMin
import com.saishaddai.blackbox.FilterChallenges.removeVowels
import com.saishaddai.blackbox.FilterChallenges.sumEvenNumbers
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FilterChallengesTest {

    @Test
    fun `filter and process list happy path`() {
        val result = filterAndProcessList(listOf(1, 2, 3, 4, 5, -9, -10))
        val expected = listOf(4, 8, -20)
        assertEquals(expected, result)
    }

    @Test
    fun `filter and process list empty list returns empty list`() {
        val result = filterAndProcessList(emptyList())
        val expected = emptyList<Int>()
        assertEquals(expected, result)
    }


    @Test
    fun `calculate cart total cost`() {
        val cart = listOf(
            FilterChallenges.Item("Apple", 0.99),
            FilterChallenges.Item("Banana", 0.49),
            FilterChallenges.Item("Orange", 1.29),
            FilterChallenges.Item("Milk", 2.99),
            FilterChallenges.Item("Bread", 1.99)
        )

        val result : Double = calculateCartTotalCost(cart)
        val expected = 7.75
        assertEquals(expected, result)
    }

    @Test
    fun `find the largest word`() {
        val words = listOf("hello", "world", "abc", "bread", "challenges")
        val result = findLongestWord(words)
        val expected = "challenges"
        assertEquals(expected, result)
    }

    @Test
    fun `calculate factorial on different scenarios`() {

        val factorialOf5 = calculateFactorial(5)
        val expected5 = 120
        assertEquals(expected5, factorialOf5)

        val factorialOf10 = calculateFactorial(10)
        val expected10 = 3628800
        assertEquals(expected10, factorialOf10)

        val factorialOf15 = calculateFactorial(15)
        val expected15 = 2004310016
        assertEquals(expected15, factorialOf15)



    }

    @Test
    fun `remove Vowels empty string returns empty`() {
        val result = removeVowels("")
        assertTrue(result.isEmpty())
    }

    @Test
    fun `remove Vowels valid string returns no vowels`() {
        val result = removeVowels("hello world")
        assertEquals("hll wrld", result)
    }

    @Test
    fun `remove Vowels string with no vowels returns input`() {
        val result = removeVowels("sdfghjkl")
        assertEquals("sdfghjkl", result)
    }


    @Test
    fun `sum Even Numbers with empty list returns zero`() {
        val result = sumEvenNumbers(listOf())
        assertEquals(0, result)
    }

    @Test
    fun `sum Even Numbers with list with no even numbers return zero`() {
        val numbers = listOf(1, 3, 5, 7, 9)
        val result = sumEvenNumbers(numbers)
        assertEquals(0, result)
    }

    @Test
    fun `sum Even Numbers with valid list return the sum`() {
        val numbers = listOf(22, 43, 55, 72, 99)
        val result = sumEvenNumbers(numbers)
        assertEquals(94, result)
    }

    @Test
    fun `filter map with empty map returns empty map`() {
        val result = filterMap(emptyMap())
        assertTrue(result.isEmpty())
    }

    @Test
    fun `filter map with valid map with no valid entries returns empty map`() {
        val inputMap = mapOf("a" to 5, "b" to 5, "c" to 0, "d" to 9)
        val result = filterMap(inputMap)
        assertTrue(result.isEmpty())
    }

    @Test
    fun `filter map with valid map returns valid map`() {
        val inputMap = mapOf("a" to 5, "b" to 15, "c" to 20, "d" to 5)
        val expected = mapOf("b" to 15, "c" to 20)
        val result = filterMap(inputMap)
        assertEquals(expected, result)
    }

    @Test
    fun `get min from a empty map should return zero`() {
        val input : Map<String, List<Int>> = mapOf()
        val result = getMin(input)
        assertEquals(0, result)
    }

    @Test
    fun `get min from a valid map should return the minimum`() {
        val input = mapOf(
            "dog" to listOf(1, 2, 3, 4, 6),
            "hello" to listOf(5, -6, 7, 8, 9),
            "really" to listOf(4, 7, 33, 56)
        )
        val result = getMin(input)
        assertEquals(-6, result)
    }



}