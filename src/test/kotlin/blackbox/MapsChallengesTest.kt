package blackbox

import com.saishaddai.blackbox.MapsChallenges
import com.saishaddai.blackbox.MapsChallenges.Student
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class MapsChallengesTest {

    @Test
    fun `test Length Of strings with variants returns right values`() {
        var result = MapsChallenges().lengthsOfStrings(listOf())
        assertNotNull(result)
        assertEquals(listOf<Int>(), result)
        result = MapsChallenges().lengthsOfStrings(listOf("Paula", "John", "Sigfrid"))
        assertNotNull(result)
        assertEquals(listOf<Int>(5, 4, 7), result)
    }


    @Test
    fun `test group students`() {
        val students = listOf(
            Student("Alice", 90),
            Student("Bob", 80),
            Student("Charlie", 90),
            Student("David", 70),
            Student("Eve", 80)
        )

        val expectedOutput = mapOf<Int, List<Student>>(
            90 to listOf(Student("Alice", 90), Student("Charlie", 90)),
            80 to listOf(Student("Bob", 80), Student("Eve", 80)),
            70 to listOf(Student("David", 70))
        )

        val result = MapsChallenges().groupStudentsByGrade(students)

        assertEquals(expectedOutput, result)

    }
}