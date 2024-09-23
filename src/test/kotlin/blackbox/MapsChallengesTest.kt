package blackbox

import com.saishaddai.blackbox.MapsChallenges
import com.saishaddai.blackbox.MapsChallenges.Purchase
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


    @Test
    fun `test calculate total cost by category`() {
        val cart = listOf(
            Purchase("Food", 10.0),
            Purchase("Electronics", 50.0),
            Purchase("Food", 20.0),
            Purchase("Clothing", 30.0),
            Purchase("Electronics", 40.0)
        )

        val expectedOutput = mapOf(
            "Food" to 30.0,
            "Electronics" to 90.0,
            "Clothing" to 30.0
        )

        val result = MapsChallenges().calculateTotalCostByCategory(cart)

        assertEquals(expectedOutput, result)

    }

}