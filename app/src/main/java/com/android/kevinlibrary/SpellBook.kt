package com.android.kevinlibrary

import java.io.IOException
import java.util.*

class SpellBook {

    @JvmField
    val spells = listOf("Magic Ms.L", "Lay on Hans")


    companion object {
        const val MAX_SPELL_COUNT = 10

        @JvmStatic
        fun getSpellBookGreeting() = println("I am the great gregoire")
    }
}

val translator = { utterance: String ->
    println(utterance.toLowerCase(Locale.ROOT).capitalize(Locale.ROOT))
}

@JvmOverloads
fun handOverFood(leftHand: String = "Berries", rightHand: String = "Beef") {
    println("Mmm... you hand over some delicious $leftHand and $rightHand.")
}

@Throws(IOException::class)
fun acceptApology() {
    throw IOException()
}