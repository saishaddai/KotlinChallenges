package com.saishaddai.personalchallenges

import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

/**
 * This is the whole logic of random selector
 * The idea behind is to select random lines of random files.
 *
 * Files: Name of files available in a local data system
 * each file as the Total Number of Lines (not blanks) in it
 * Selections: A list of File names and the list of independent
 * lines to retrieve from each file.
 *
 * Size: the number of total lines to retrieve. This is independent of
 * the number of files. This number is provided by the user
 * but at the same time, it is the sum of all the lines from all the selections
 * Priorities: We randomly select how many lines we will retrieve of each file.
 * For example
 * File1, 3 lines to retrieve
 * File2, 4 lines to retrieve
 * File3, 2 lines to retrieve
 * File4, 1 line to retrieve
 *
 * Again, notice that the sum of this example (10) must coincide with the size
 * parameter in the method in getSelections method
 *
 */
class RandomSelector {

    data class Item(val fileName: String, val totalLines: Int)
    data class Selection(val fileName: String, val questionLines : List<Int>)

    fun getSelections(size: Int, list: List<Item>) : List<Selection>{
        if(size <= 0) return emptyList()

//        val priorities : Map<Item, Int> =
//            throwDices(list.size)
//            .getNumberOfPicksPerFile()

//        priorities.forEach{priority ->
//            priority.key.
//        }
        return emptyList()
    }

    fun throwDices(dices : Int) : List<Int> {
        val validDices : Int = if(dices < 0) 0 else dices
        return List(validDices) { nextInt(1, 6) }
    }

    fun getPriorityMap(diceValues : List<Int>) {
        //get sum of all the values in the dices
        //iterate the list
        //for each dice item, get its value with the following formula
        //numberOfPicks =  round( (itemvalue * size ) / sum)
        //with this value set an entry of the map: Filename to numberOfPicks
//        6+5 = 11 = 100%
//        6 -> (6*20)/11 = 10.9
//        5 -> (5*20)/11 = 9.09

    }

    fun getNumberOfPicks(diceValue : Int, size : Int, sum: Int) =
        Math.round(((diceValue * size ) / sum).toDouble()).toInt()

    fun compensateValues(map: MutableMap<String, Int>, size: Int) : MutableMap<String, Int> {
        //get sum of all the values of the map -> sumValues
        val sum = map.values.sum()
        //get distance between sumValues and size -> alpha
        val alpha = size - sum
        if (alpha == 0) {
            return map
        } else {
            //get the minimum map entry with minimum value and add the alpha to it.
            val minValue = map.values.min()
            val key = map.filterValues { it == minValue }.keys.firstOrNull()
            key?.let {
                val newValue = map[key]?.plus(alpha)
                newValue?.let {
                    map[key] = it
                }
            }
        }
        return map
    }

    private fun <E> List<E>.getNumberOfPicksPerFile(): Map<Item, E> {
//        * File1, 3 lines to retrieve
//        * File2, 4 lines to retrieve
//        * File3, 2 lines to retrieve
//        * File4, 1 line to retrieve
        //
        return mapOf()
    }

}


