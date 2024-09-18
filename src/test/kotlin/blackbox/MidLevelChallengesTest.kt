package blackbox

import com.saishaddai.blackbox.MidLevelChallenges.findClosestPair
import com.saishaddai.blackbox.MidLevelChallenges.findClosestPair2
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MidLevelChallengesTest {

    @Test
    fun `find closest pair of empty input list returns empty list`() {
        var result = findClosestPair(listOf())
        assertNotNull(result)
        assertTrue(result.isEmpty())
        result = findClosestPair(listOf(1))
        assertNotNull(result)
        assertTrue(result.isEmpty())
    }

    @Test
    fun `find closest pair of duplicate entries returns any of them`() {
        val input = listOf(18, 78, 1, 6, 99, 7, 22, 78)
        val expected = listOf(6, 7)
        val result = findClosestPair(input)
        assertNotNull(result)
        assertEquals(expected, result)
    }

    @Test
    fun `find closest pair returns the right one`() {
        val input = listOf(18, 78, 1, 36, 99, 6, 22, 208)
        val expected = listOf(18, 22)
        val result = findClosestPair(input)
        assertNotNull(result)
        assertEquals(expected, result)
    }


    @Test
    fun `find closest pair 2 of empty input list returns empty list`() {
        var result = findClosestPair2(listOf())
        assertNull(result)
        result = findClosestPair2(listOf(1))
        assertNull(result)
    }

    @Test
    fun `find closest pair 2 of duplicate entries returns any of them`() {
        val input = listOf(18, 78, 1, 6, 99, 7, 22, 78)
        val expected = 78 to 78
        val result = findClosestPair2(input)
        assertNotNull(result)
        assertEquals(expected, result)
    }

    @Test
    fun `find closest pair 2 returns the right one`() {
        val input = listOf(18, 78, 1, 36, 99, 6, 22, 208)
        val expected = 18 to 22
        val result = findClosestPair2(input)
        assertNotNull(result)
        assertEquals(expected, result)
    }
}