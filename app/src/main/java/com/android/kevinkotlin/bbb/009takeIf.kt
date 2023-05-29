package com.android.kevinkotlin.bbb

import java.io.File

/*

takeIf

和其他标准函数有点不一样，takeIf函数需要判断lambda中提供的条件表达式，给出true或false结果，如果判断结果是true，从takeIf函数返回接收者对象，如果是false，则返回null

如果需要判断某个条件是否满足，再决定是否可以赋值或执行某项任务，takeIf就非常有用，概念上讲，takeIf函数类似于if语句，但它的优势是可以直接在对象实例上调用，避免了临时变量赋值的麻烦


takeUnless 和takeIf相反
 */


fun main() {
    val result = File("C:\\Users\\wankai\\Desktop\\崩坏星穹.txt")
        .takeIf { it.exists() && it.canRead() }
        ?.readText()
    println(result)
}