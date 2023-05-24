package com.android.kevinkotlin

/*

it 关键字

定义只有一个参数的匿名函数时，可以使用it关键字来表示参数名
当你需要传入两个值参，it关键字就不能使用了


 */
fun main() {

    val blessingFunction: (String) -> String = {
        val holiday = "Ney Year."
        "$it, Happy $holiday"
    }

    println(blessingFunction("Jack"))
}