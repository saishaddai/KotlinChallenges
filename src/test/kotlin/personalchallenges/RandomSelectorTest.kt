package personalchallenges

import com.saishaddai.personalchallenges.RandomSelector
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class RandomSelectorTest {

    private val listOfItems = listOf(
        RandomSelector.Item("N.Y. Tonight", 300),
        RandomSelector.Item("What a life", 34),
        RandomSelector.Item("Titanic", 165),
        RandomSelector.Item("Purple Rain", 40),
        RandomSelector.Item("L.A. Writer", 5)
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


}