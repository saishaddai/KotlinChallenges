package com.saishaddai.personalchallenges

import kotlin.math.abs

/**
 * The following challenges are the ones I created myself to understand maps
 */
object MapsChallenges {

    data class Item(val name: String, val price: Double)

    /**
     * get the max and min of prices in the same map and reduce call
     */
    fun getMaxAndMinPrice(list: List<Item>) : Pair<Double, Double> =
        list
            .map { abs( it.price ) to abs( it.price) }
            .reduce { acc, pair ->
                pair.first.coerceAtLeast(acc.first) to
                        pair.second.coerceAtMost(acc.second)
        }


    /**
     * get a list of items without the max and min. You can reuse the method above
     */
    fun getListWithoutMaxAndMinPrices(list: List<Item>) : List<Item> {
        val maxAndMin = getMaxAndMinPrice(list)
        return list
            .filter { item -> abs( item.price ) != maxAndMin.first }
            .filter { item -> abs( item.price ) != maxAndMin.second }
    }

    /**
     * get the sum of prices without max and min
     */
    fun getSumOfPrices(list: List<Item>) : Double =
        getListWithoutMaxAndMinPrices(list).sumOf { abs (it.price) }



    /**
     * get the AVG of prices without max and min
     */
    fun getAvgPriceWithoutMaxAndMin(list: List<Item>) : Double {
        val narrowedList = getListWithoutMaxAndMinPrices(list)
        val prices = mutableListOf<Double>()
        narrowedList.map { item ->
            prices.add(abs (item.price))
        }
        return prices.average()
    }

    /**
     * use flatMap to get a list of Items with the min value of different carts
     */
    data class Person(val name: String, val friends: List<String>)

    fun getFullListOfPeople(persons: List<Person>) = persons.flatMap { it.friends }

}