package com.example.androiddevelopment.kotlin_concepts.variables


fun creatingVariablesInKotlin() {


    /// [remember to init variable even if it's nullable value]

    val integerValueWithNullable: Int? = null
    //
    var integerValueWithValue: Int = 10

    integerValueWithValue = 10;


    // val is just like const keyword

    // String
    // Int
    // Double
    // Float
    // Boolean

    var stringValueWithValue: String? = "Avaz";

    stringValueWithValue = null;

    //

    println(
        "print getting variables : $integerValueWithNullable | $integerValueWithValue" + "| $stringValueWithValue"
    )


    //
    val listOfImmutableNumbers = listOf<Int>(10, 14, 2); // means that list never changes
    val listOfNumber = mutableListOf<Int>(12, 14, 44);


    //
    val setOfImmutableNumbers = setOf<Int>(5, 3, 2); // means that set never changes
    var setOfNumber = mutableSetOf<Int>();


    //
    val mapOfImmutableNumbers = mapOf<Int, Int>(12 to 10, 22 to 30); // means that map never changes
    var mapOfNumber = mutableMapOf<Int, Int>();

    listOfNumber.add(10);


    val anotherList = listOfImmutableNumbers.filter { e -> e > 2 }.toList()

    println("another list is: $anotherList")

    for (n in mapOfImmutableNumbers) {
        println("each number: ${n.value}")
    }
}