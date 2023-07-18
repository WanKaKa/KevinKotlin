package com.android.kevinkotlin.bbb


/*

集合

集合可以方便你处理一组数据，也可以作为值参传给函数，和我们学过的其他变量类型一样，List、Set和Map类型的变量也是分为两类，只读和可变



可变列表
在kotlin中，支持内容修改的列表叫做可变列表，要创建可变列表，可是使用mutableListOf函数，List还支持使用toList和toMutableList函数动态实现只读列表和可变列表的相互转换



mutator 函数
1. 能修改可变列表的函数有个统一的名字：mutator函数
2. 添加元素的运算符和删除元素的运算符
3. 基于lambda表达式指定的条件删除元素





解构
通过_符号过滤不想要的元素
 */


fun main() {
    val list = listOf("Jason", "Jack", "Jacky")
//    println(list[3])
    println(list.getOrElse(2) { "Unknown" })
    println(list.getOrNull(2)?.let { "Gun" } ?: "Unknown")


    val mutableList = mutableListOf("Jason", "Jack", "Jacky")
//    println(mutableList.toList())
//    mutableList.remove("Jack")
//    println(mutableList)


//    mutableList += "Jimmy"
//    mutableList.removeIf { it.contains("Jack") }
//    println(mutableList)


    mutableList.forEachIndexed { index, item ->
        println("$index $item")
    }


//    val (origin, des, proxy) = list
//    val (origin, _, proxy) = list
    val (origin, _, _) = list
}