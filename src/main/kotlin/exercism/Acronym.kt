package com.saishaddai.exercism

object Acronym {

    fun generate(phrase: String) =
        phrase
            .split("[-_\\s]".toRegex())
            .map {
                if ( it.isNotEmpty() ) it[0].uppercaseChar() else ""
            }
            .joinToString("")

}