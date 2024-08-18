package personalchallenges

import com.saishaddai.personalchallenges.MapsChallenges.Item
import com.saishaddai.personalchallenges.MapsChallenges.Person
import com.saishaddai.personalchallenges.MapsChallenges.getAvgPriceWithoutMaxAndMin
import com.saishaddai.personalchallenges.MapsChallenges.getFullListOfPeople
import com.saishaddai.personalchallenges.MapsChallenges.getListWithoutMaxAndMinPrices
import com.saishaddai.personalchallenges.MapsChallenges.getMaxAndMinPrice
import com.saishaddai.personalchallenges.MapsChallenges.getSumOfPrices
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MapsChallengesTest {

    private val cart = listOf(
        Item("bread", 5.75),
        Item("buns", 6.70),
        Item("negative number", -1.89)
    )

    @Test
    fun `get Max And Min Price negative number must be positive`() {
        val result = getMaxAndMinPrice(cart)
        val expected = Pair(6.70, 1.89)
        assertEquals(expected, result)
    }

    @Test
    fun `get List Without Max And Min Prices`() {
        val result = getListWithoutMaxAndMinPrices(cart)
        println(result)
        val expected = listOf(Item("bread", 5.75))
        assertEquals(expected, result)
    }

    @Test
    fun `get Sum Of Prices`() {
        val result = getSumOfPrices(cart)
        val expected = 5.75
        assertEquals(expected, result)
    }

    @Test
    fun `get Average price without Max and Min`() {
        val result = getAvgPriceWithoutMaxAndMin(cart)
        val expected = 5.75
        assertEquals(expected, result)
    }

    @Test
    fun `test Flat Map higher order function`() {
        val people = listOf(
            Person("John", listOf("Alice", "Bob")),
            Person("Alice", listOf("John", "Charlie")),
            Person("Bob", listOf("John", "David"))
        )
        val actual = getFullListOfPeople(people)
        val expected = listOf("Alice", "Bob", "John", "Charlie", "John", "David")
        assertNotNull(actual)
        assertTrue(actual.isNotEmpty())
        kotlin.test.assertEquals(expected, actual)
    }
}