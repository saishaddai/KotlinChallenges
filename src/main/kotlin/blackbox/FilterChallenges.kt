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
    fun filterAndProcessList(list: List<Int>) : List<Int>{
        val evens = list.filter{i ->
            i % 2 == 0}

        val evensDoubles = evens.map{i ->
            i * 2}

        return evensDoubles
    }

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


}