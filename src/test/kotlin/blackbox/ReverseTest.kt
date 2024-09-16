package blackbox

import com.saishaddai.blackbox.Reverse
import kotlin.test.Test
import kotlin.test.assertEquals

class ReverseTest {

    @Test
    fun `reverse with an empty string returns empty string`() {
        val reverse = Reverse()
        val result = reverse.reverseString("")
        assertEquals(expected = "", result)
    }


    @Test
    fun `reverse with an valid string returns reversed string`() {
        val reverse = Reverse()
        val input = "hello world"
        val expected = "dlrow olleh"
        val result = reverse.reverseString(input)
        assertEquals(expected, result)
    }
}