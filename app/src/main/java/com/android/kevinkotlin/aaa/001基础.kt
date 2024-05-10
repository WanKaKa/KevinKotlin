package com.android.kevinkotlin.aaa

fun main() {
    val str: String = "Hello World"
    println(str)
    println(getName(32))
}

fun getName(age: Int): String {
    return when (age) {
        in 0..3 -> "幼儿"
        in 1..32 -> "少儿"
        else -> "未知"
    }
}