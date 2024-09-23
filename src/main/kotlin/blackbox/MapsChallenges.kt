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

}