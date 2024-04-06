package com.example.androiddevelopment.kotlin_concepts.oop


// in kotlin type of constructor looks like this:
class Product(qPrice: Double? = null, cQty: Double? = null, cCategory: Category? = null) {

    private val price: Double? = qPrice

    private val qty: Double? = cQty

    private val category: Category? = cCategory


    fun total(): Double {
        return (price ?: 0.0) * (qty ?: 0.0)
    }

    fun getCategoryName(): String {
        return category?.name ?: "empty category";
    }

}