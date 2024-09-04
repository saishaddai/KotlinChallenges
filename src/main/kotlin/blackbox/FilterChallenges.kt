package com.saishaddai.blackbox

/**
 * The following are tests that I asked to blackbox with filters, maps and reduces
 */

object FilterChallenges {

    /**
     * The following receives a list of integers, gets the even numbers and
     * multiplies by two
     * @param list a list of numbers
     * @return a list of even numbers multiplied by two
     */
    fun filterAndProcessList(list: List<Int>) = list.filter { it % 2 == 0 }.map { it * 2 }

    /**
      Exercise: Calculate the total cost of a shopping cart
      You have a list of Item objects, each with a price property. Write a function that
      uses the reduce function to calculate the total cost of all items in the cart. Item class
     */
    data class Item(val name: String, val price: Double)

    /**
     Task
     Write a function calculateTotalCost that takes the cart list as an argument and returns the total cost of all items in the cart using the reduce function.
     */
    fun calculateCartTotalCost(cart: List<Item>) =
        cart
            .reduce { acc, element -> Item("total", acc.price + element.price) }
            .price


    /**
     * Exercise: Find the longest word in a list of strings
     */

    fun findLongestWord(words: List<String>) = words
        .reduce { lastWord, currentWord ->
            if (currentWord.length > lastWord.length) currentWord else lastWord }


    /**
     * Exercise: calculate the factorial of a number using reduce
     */
    fun calculateFactorial(number : Int) =
        List(number) { i -> i + 1 }
            .reduce{ acc, current -> acc * current }


    private const val VOWELS = "aeiou"
    /**
     * Remove Vowels of any given string
     */
    fun removeVowels(input: String) =
        input.filter { character -> !VOWELS.contains(character) }


    /**
     * sum even numbers from a list of integers
     */
    fun sumEvenNumbers(numbers: List<Int>) =
        numbers.filter { number -> number % 2 == 0 }.sum()


    /**
     * Write a Kotlin function that takes a map of strings to integers as an
     * input and returns a new map with only the entries where the value is
     * greater than 10.
     * Input: {"a" to 5, "b" to 15, "c" to 20, "d" to 5}
     * Output: {"b" to 15, "c" to 20}
     */
    fun filterMap(input: Map<String, Int>) =
        input.filter { entry -> entry.value > 10 }


    /**
     * Create a method that takes all the values of a map,
     * The values are list on integers, and you must take the minimum of all the lists together
     */
    fun getMin(input: Map<String, List<Int>>) =
        input.values
            .flatten()
            .minOrNull() ?: 0


    /**
     * Given a list of numbers, get a new one where each entry is the sum of other entries of the original input
     */
    fun sumEntries(numbers: List<Int>) : List<Int>{
        val sum = numbers.sum()
        return numbers.map { number ->
            number * (sum - number)
        }
    }

    fun findLongestCommonPrefix(words: List<String>) : String {
        return when(words.size) {
            0 -> ""
            1 -> words.single()
            else -> findLongestPrefix(words)
        }
    }

    private fun findLongestPrefix(words: List<String>) : String {
        val prefixes = mutableListOf<String>()
        for( i in 0 until words.size - 1) {
            val currentPrefix = words[i].zip(words[i + 1])
                .takeWhile { pair -> pair.first == pair.second }
                .map { it.first }
                .joinToString("")
            prefixes.add(currentPrefix)
        }
        return prefixes.min()
    }
}