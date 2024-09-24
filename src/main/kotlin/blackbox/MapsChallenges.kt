package com.saishaddai.blackbox

class MapsChallenges {

    fun lengthsOfStrings(names: List<String>) : List<Int> = names.map { it.length }

    data class Student(val name: String, val grade: Int)
    fun groupStudentsByGrade(students: List<Student>) = students.groupBy{ it.grade }


    data class Purchase(val category: String, val cost: Double)
    fun calculateTotalCostByCategory(cart: List<Purchase>): Map<String, Double> {
        return cart.groupBy { purchase -> purchase.category }
            .map { (category, purchases) ->
                val totalCost = purchases.sumOf { purchase -> purchase.cost }
                category to totalCost
            }.toMap()
    }

    data class Product(val name: String, val price: Double)
    fun findMostExpensiveProduct(products: List<Product>) : Product? = products.maxByOrNull { it.price }

    fun countPairsWithDifference(numbers: List<Int>, k: Int): Int {
        if (numbers.isEmpty()) return 0
        val freqMap = numbers.groupBy { it }.mapValues { it.value.size }
        var pairsWithDifference = 0
        for ((num, freq) in freqMap) {
            val targetNum = num + k
            if (freqMap.containsKey(targetNum)) {
                pairsWithDifference += freq * freqMap[targetNum]!!
            }
        }
        return pairsWithDifference
    }

}