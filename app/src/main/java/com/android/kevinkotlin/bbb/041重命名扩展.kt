package com.android.kevinkotlin.bbb


import com.android.kevinlibrary.randomTake as randomizer

/*

重命名扩展
有时候，你想使用一个扩展或一个类，但是它的名字不和你的意

 */


fun main() {
    val list = listOf("Jack", "Jimmy", "YuKi")
    val set = setOf("Jack", "Jimmy", "YuKi")
    println(list.randomizer())
    println(set.randomizer())
}