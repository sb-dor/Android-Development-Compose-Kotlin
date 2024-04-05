package com.example.androiddevelopment.variables


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
}