package com.saishaddai.exercism

object Acronym {

    fun generate(phrase: String) =
        phrase
            .split("[-_\\s]".toRegex())
            .filter { it.isNotEmpty() }
            .map { it[0].uppercaseChar() }
            .joinToString("")

}
