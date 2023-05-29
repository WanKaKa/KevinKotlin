package com.android.kevinkotlin.bbb


/*

Set创建和元素获取

通过setOf创建set集合，使用elementAt函数读取集合中的元素


可变集合
通过mutableSetOf创建可变的set集合

 */


fun main() {
    val set = setOf("Jason", "Jack", "Jacky", "Jack")
    println(set.elementAt(2))

    val mutableSetOf = mutableSetOf("Jason", "Jack", "Jacky", "Jack")
    mutableSetOf += "Jimmy"
    println(mutableSetOf)

    println(listOf("Jason", "Jack", "Jacky", "Jack").distinct())
}