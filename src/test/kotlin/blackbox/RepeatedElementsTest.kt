package blackbox

import com.saishaddai.blackbox.RepeatedElements.findFirstDuplicate
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RepeatedElementsTest {

    @Test
    fun `find First Duplicate with empty or null list returns -1`() {
        var result = findFirstDuplicate(null)
        assertEquals(-1, result)
        result = findFirstDuplicate(listOf<Int>())
        assertEquals(-1, result)
    }

    @Test
    fun `find First Duplicate with valid list and no duplicates returns -1`() {
        val numbers = listOf(1, 2, 4, 5, 6, 7, 8, 9)
        var result = findFirstDuplicate(numbers)
        assertEquals(-1, result)
    }

    @Test
    fun `find First Duplicate with valid list returns first duplicated`() {
        val numbers = listOf(1, 2, 9, 5, 5, 7, 8, 9)
        var result = findFirstDuplicate(numbers)
        assertEquals(5, result)
    }

}