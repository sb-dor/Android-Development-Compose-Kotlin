package com.example.androiddevelopment.kotlin_concepts.oop.open_class

open class SmartTelevision(cNameOfTV: String? = null) {


    // calls when object of class initializes
    init {
        println("type of tv : ${this::class.java.typeName}");
    }

    val nameOfTV: String? = cNameOfTV;

    var channelNumber: Int = 1;

    open fun switchOn() {
        println("Im switching on");
    }

    open fun incrementChannel() {
        println("incrementing channel")
    }

    open fun decrementChannel() {
        println("decrementing channel")
    }

}


class LGTelevision(deviceName: String?) : SmartTelevision(cNameOfTV = deviceName) {
    override fun switchOn() {
        super.switchOn()
        println("LGTELEVISION")
    }

    override fun incrementChannel() {
        super.incrementChannel()
        channelNumber++;
        println("channelNumber value is : $channelNumber");
    }

    override fun decrementChannel() {
        super.decrementChannel()
        channelNumber--;
        println("channelNumber value is : $channelNumber");
    }

}

