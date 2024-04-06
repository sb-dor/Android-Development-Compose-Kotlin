package com.example.androiddevelopment.kotlin_concepts.when_statement

fun WhenStateMent() {
    // when statement is another type of if statement

    val someBooleanValue: Boolean = true;


//    if (someBooleanValue) {
//    } else {
//    }


    when (someBooleanValue) {
        true -> {
            println("is true value")
        }

        false -> {
            print("is false value")
        }
    }


    var trafficLightValue: String? = "YELLOW"

    when (trafficLightValue) {
        "RED" -> {
            println("cars should not drive")
        }

        "GREEN" -> {
            println("cars should drive")
        }

        "YELLOW" -> {
            println("cars should wait before drive drive and stopping")
        }

    }

    trafficLightValue = "ANOTHER";

}