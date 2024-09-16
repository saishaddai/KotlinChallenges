package com.saishaddai.blackbox

class Reverse {

    fun reverseString(input: String): String {
        var result = ""
        input.forEach {
            result = it + result
        }.toString()

        return result
    }

}