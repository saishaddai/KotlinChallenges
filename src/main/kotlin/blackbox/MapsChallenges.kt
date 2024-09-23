package com.saishaddai.blackbox

class MapsChallenges {

    fun lengthsOfStrings(names: List<String>) : List<Int> = names.map { it.length }

    data class Student(val name: String, val grade: Int)
    fun groupStudentsByGrade(students: List<Student>) = students.groupBy{ it.grade }


}