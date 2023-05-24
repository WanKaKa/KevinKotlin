package com.android.mylibrary


/*

Map的创建

to看上去像关键字，但事实上，它是个省略了点号和参数的特殊函数，to函数将它左边和右边的值转化成一对Pair


读取Map的值
[]取值运算符，读取键对应的值，如果键不存在就返回null
getValue 读取键对应的值，如果键不存在就抛出异常
getOrElse 读取键对应的值，或者使用匿名函数返回默认值
getOrDefault 读取键对应的值，或者返回默认值


遍历

 */


fun main() {
    val mapOf = mapOf("Jack" to 20, "Jason" to 18, "Jack" to 30)
    println(mapOf["Jack"])
    println(mapOf.getValue("Jack"))
    println(mapOf.getOrElse("Rose") { "Unknown" })
    println(mapOf.getOrDefault("Rose", 0))


    mapOf.forEach {
        println("${it.key} ${it.value}")
    }

    mapOf.forEach { (key: String, value: Int) ->
        println("$key $value")
    }

    val mutableMap = mutableMapOf("Jack" to 20, "Jason" to 18, "Jack" to 30)
    mutableMap += "Jimmy" to 69
    mutableMap["Jimmy"] = 26
}