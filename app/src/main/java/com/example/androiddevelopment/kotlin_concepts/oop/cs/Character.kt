package com.example.androiddevelopment.kotlin_concepts.oop.cs

import com.example.androiddevelopment.kotlin_concepts.oop.cs.weapon.Weapon

abstract class Say {
    fun scream() {
        print("screaming out of loud");
    }
}

interface Character {
    val name: String?;

    val weapon: Weapon?;

    fun fire() = weapon?.fire();

}


class RedSide(override val name: String?, override val weapon: Weapon?) : Character, Say() {}

class BlueSide(override val name: String?, override val weapon: Weapon?) : Character, Say() {}