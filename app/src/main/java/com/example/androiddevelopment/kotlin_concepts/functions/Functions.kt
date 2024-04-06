package com.example.androiddevelopment.kotlin_concepts.functions

// function that can return null or String
fun happyBirthdayPrint(nameOfPerson: String? = null, age: Int = 0): String {

    // like in dart's annotation "??" in kotlin use -> "?:"

    return "Happy birthday brother ${nameOfPerson ?: "Bro"} with your $age birthday";
}