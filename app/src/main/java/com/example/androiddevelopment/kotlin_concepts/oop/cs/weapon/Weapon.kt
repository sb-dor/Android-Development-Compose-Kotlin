package com.example.androiddevelopment.kotlin_concepts.oop.cs.weapon

interface Weapon {
    var ammunition: Int?;

    fun fire();
}


class M416(override var ammunition: Int?) : Weapon {
    override fun fire() {
        ammunition = (ammunition ?: 0) - 1;
        println("shooting with M416 : ammunition is -> $ammunition");
    }


}


class AK47(override var ammunition: Int?) : Weapon {
    override fun fire() {
        ammunition = (ammunition ?: 0) - 1;
        println("shooting with AK47 : ammunition is -> $ammunition");
    }

}