package com.android.kevinkotlin.ccc

import com.android.kevinlibrary.JavaExample
import java.util.*


/*


互操作性与可空性
java世界里所有对象都可能时null，当一个kotlin函数返回String类型值，你不能想当然地认为它的返回值就能符合kotlin关于空值的规定


 */



fun main() {
    val adversary = JavaExample()
    println(adversary.utterGreeting())

    val level = adversary.determineFriendshipLevel()
    level?.toLowerCase(Locale.ROOT)
}