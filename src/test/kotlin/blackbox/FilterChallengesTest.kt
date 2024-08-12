package blackbox

import com.saishaddai.blackbox.FilterChallenges
import com.saishaddai.blackbox.FilterChallenges.filterAndProcessList
import com.saishaddai.blackbox.FilterChallenges.calculateCartTotalCost
import com.saishaddai.blackbox.FilterChallenges.calculateFactorial
import com.saishaddai.blackbox.FilterChallenges.findLongestWord
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

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




}