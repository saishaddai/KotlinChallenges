package blackbox

import com.saishaddai.blackbox.MidLevelChallenges.findClosestPair
import com.saishaddai.blackbox.MidLevelChallenges.findClosestPair2
import com.saishaddai.blackbox.MidLevelChallenges.maxProductSubArray
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

    @Test
    fun `get max product Sub array from an empty list`() {
        val result =  maxProductSubArray(listOf<Int>())
        assertEquals(0, result)
    }

    @Test
    fun `get max product Sub array from a all positives list`() {
        val result =  maxProductSubArray(listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8))
        val expected  = 40320
        assertEquals(expected, result)
    }

    @Test
    fun `get max product Sub array from a list with a zero must ignore zero`() {
        val result =  maxProductSubArray(listOf<Int>(1, 2, 3, 4, 0, 5, 6, 7, 8))
        val expected  = 40320
        assertEquals(expected, result)
    }

    @Test
    fun `get max product Sub array from a list with an even combination of negative numbers`() {
        val result =  maxProductSubArray(listOf<Int>(1, -2, 3, 4, 0, -5, 6, 7, 8))
        val expected  = 40320
        assertEquals(expected, result)
    }

    @Test
    fun `get max product Sub array from a list with an odd combination of negative numbers`() {
        val result =  maxProductSubArray(listOf<Int>(1, -4, -2, -3, 0, 5, 6, 7, 8)) //1, -4, -3, 5, 6, 7, 8
        val expected  = 20160
        assertEquals(expected, result)
    }


}