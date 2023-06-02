package com.android.kevinkotlin.bbb

import com.android.kevinlibrary.randomTake


/*

定义扩展文件
扩展函数需要在多个文件里面使用，可以将它定义在单独的文件，然后import

 */


fun main() {
    val list = listOf("Jack", "Jimmy", "YuKi")
    val set = setOf("Jack", "Jimmy", "YuKi")
    println(list.randomTake())
    println(set.randomTake())
}