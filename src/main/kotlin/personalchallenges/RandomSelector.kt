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

//        val priorities : Map<Item, Int> = throwDices().getNumberOfPicksPerFile()
//        priorities.forEach{priority ->
//            priority.key.
//        }
        return emptyList()
    }

    /**
     * This is a race of each file and who has a bigger number
     */
    fun throwDices(dices : Int) : List<Int> {
        val validDices : Int = if(dices < 0) 0 else dices
        return List(validDices) { nextInt(1, 6) }
    }

}