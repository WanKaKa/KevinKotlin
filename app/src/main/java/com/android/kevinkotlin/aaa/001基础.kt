package com.android.kevinkotlin.aaa

fun main() {
    val str: String = "Hello World"
    println(str)

    when (4) {
        in 0..3 -> println("幼儿")
        in 1..32 -> println("少儿")
        else -> println("未知")
    }
}