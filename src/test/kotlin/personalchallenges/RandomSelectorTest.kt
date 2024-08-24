package personalchallenges

import com.saishaddai.personalchallenges.RandomSelector
import com.saishaddai.personalchallenges.RandomSelector.Item
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class RandomSelectorTest {

    private val listOfItems = listOf(
        Item("N.Y. Tonight", 300),
        Item("What a life", 34),
        Item("Titanic", 165),
        Item("Purple Rain", 40),
        Item("L.A. Writer", 5)
        )

    //@Test
//    fun `get Selections happy path`() {
//        val selector = RandomSelector()
//        val selections = selector.getSelections(20, listOfItems)
//        assertNotNull(selections)
//        assertEquals(selections.size, 20)//this is not true. Fix
//        //assert that all the selection items, sums altogether 20
//    }

    @Test
    fun `get selections with zero as parameter`() {
        val selector = RandomSelector()
        val selections = selector.getSelections(0, listOfItems)
        assertNotNull(selections)
        assertEquals(selections.size, 0)
    }

    @Test
    fun `throw dices with valid number`() {
        val result = RandomSelector().throwDices(4)
        result.forEach {
            assertTrue(it in 1..6)
        }
        assertNotNull(result)
        assertEquals(result.size, 4)
    }

    @Test
    fun `throw dices zero should return an empty list`() {
        val result = RandomSelector().throwDices(0)
        assertNotNull(result)
        assertEquals(result.size, 0)
    }

    @Test
    fun `throw dices negative number should return an empty list`() {
        val result = RandomSelector().throwDices(-1)
        assertNotNull(result)
        assertEquals(result.size, 0)
    }

    @Test
    fun `get number of picks with valid numbers`() {
        val result1 = RandomSelector().getNumberOfPicks(1, 20, 7)
        assertTrue( result1 <= 20)
        val result6 = RandomSelector().getNumberOfPicks(6, 20, 7)
        println("$result1 and $result6")
        assertTrue( result6 <= 20)
        assertTrue(result1 < result6)
        assertTrue( result1 + result6 <= 20)
    }


    @Test
    fun `compensate with valid numbers wont compensate`() {
        val map = mutableMapOf(
            "Title 1" to 3,
            "Title 2" to 5,
            "Title 3" to 8,
            "Title 4" to 4
        )
        RandomSelector().compensateValues(map, 20)
        assertEquals(map.values.sum(), 20)
        assertEquals(map["Title 1"],  3)
        assertEquals(map["Title 2"],  5)
        assertEquals(map["Title 3"],  8)
        assertEquals(map["Title 4"],  4)
    }

    @Test
    fun `compensate with valid numbers`() {
        val map = mutableMapOf(
            "Title 1" to 3,
            "Title 2" to 5,
            "Title 3" to 7,
            "Title 4" to 3
        )
        RandomSelector().compensateValues(map, 20)
        assertEquals(map.values.sum(), 20)
        assertEquals(map["Title 1"],  5)
        assertEquals(map["Title 2"],  5)
        assertEquals(map["Title 3"],  7)
        assertEquals(map["Title 4"],  3)
    }

    @Test
    fun `item to selection with valid numbers`() {
        val item = Item("N.Y. Tonight", 300)
        val result = RandomSelector().itemToSelection(item, 16)
        assertEquals(result.questionLines.size, 16)
        println(result.questionLines)
    }


}