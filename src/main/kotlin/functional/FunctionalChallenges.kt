package com.saishaddai.functional

class FunctionalChallenges {
    /**
     * here's the challenge: Create whatever it is needed in order to call a function by this way
     * method(2)(3){ it * 2 } adn
     */

    fun sum1(a: Int): (Int, (Int) -> Int) -> Int = { b, f  -> f(a + b)}


    /**
     * method(2)(3)()
     */
    fun multiX2(c: Int): () -> Int = { c * 2 }
    fun sum2(a: Int): (Int) -> () -> Int = { b: Int -> multiX2(a + b) }


}

fun main() {
    val functional= FunctionalChallenges()
    val r = functional.sum1(2)(3){ it * 2 }
    println(r)
    val s = functional.sum2(2)(3)()
    println(s)
}