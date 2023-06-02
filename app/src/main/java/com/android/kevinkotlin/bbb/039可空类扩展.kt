package com.android.kevinkotlin.bbb

/*

可空类扩展

你也可以定义扩展函数用于可空类型，在可空类型上定义扩展函数，你就可以直接在扩展函数体内解决可能出现的空值问题

infix关键字
infix关键字适用于有单个参数的扩展和类函数，可以让你以更简洁的语法调用函数，
如果一个函数定义使用了infix关键字，那么调用它时，接收者和函数之间的点操作以及参数的一对括号都可以不要了

 */

fun String?.printWithDefault39(default: String) = println(this ?: default)
infix fun String?.printWithDefault391(default: String) = println(this ?: default)

fun main() {
    val nullableString: String? = null
    nullableString.printWithDefault39("字符为空")
    nullableString printWithDefault391 "字符为空"
}