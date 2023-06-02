package com.android.kevinkotlin.bbb


/*

定义扩展函数

扩展可以在不直接修改类定义的情况下增加类功能。扩展可以用于自定义类，也可以用于比如List，String，
以及Kotlin标准库里的其他类。和继承相似，扩展也能共享类行为，在你无法接触某个类定义，或者某个类没有使用open修饰符，导致你无法继承它时，
扩展就是增加类功能的最好选择


定义扩展函数和定义一般函数差不多，但有一点不大一样，除了函数定义，你还需要指定接受功能扩展的接收者类型

 */


// 给字符串追加若干个感叹号
fun String.addExt(amount: Int = 1) = this + "!".repeat(amount)

fun String.easyPrint(): String {
    println(this)
    return this
}

fun main() {
    println("abc".addExt(2))
    "abc".easyPrint().addExt(3)
}