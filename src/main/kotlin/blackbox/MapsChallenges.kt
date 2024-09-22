package com.saishaddai.blackbox

class MapsChallenges {

    fun lengthsOfStrings(names: List<String>) : List<Int> = names.map { it.length }

    data class Student(val name: String, val grade: Int)
    fun groupStudentsByGrade(students: MutableList<Student>) : Map<Int, MutableList<Student>> {
        val result = mutableMapOf<Int, MutableList<Student>>()
        students.map { student ->
            var element = result[student.grade]
            if(element == null) {
                result[student.grade] = mutableListOf(student)
            } else {
                element.add(student)
            }
        }
        return result
    }


}