package com.saishaddai.blackbox

class Reverse {

    fun reverseString(input: String): String {
        val result = StringBuilder()
        input.forEach {
            result.insert(0, it)
        }

        return result.toString()
    }

}