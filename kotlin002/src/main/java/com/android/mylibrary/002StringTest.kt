package com.android.mylibrary


/*

split
split函数返回的是list集合数据，list集合又支持结构语法特性，它允许你在一个表达式里给多个变量赋值，解构常用来简化变量赋值


字符串比较
在kotlin中，用==检查两个字符串中的字符是否匹配，用===检查两个变量是否指向内存堆上同一对象
而在java中==做引用比较，解构比较时用equals方法


字符串遍历

 */


const val NAME = "Jimmy's friend"
const val NAMES = "Jack,Jacky,Jason"

fun main() {
    val index = NAME.indexOf("\'")
    println(NAME.substring(0, index))
    println(NAME.substring(0 until index))

    val data = NAMES.split(",")
    val (origin, dest, proxy) = NAMES.split(",")
    println("$origin $dest $proxy")


    val str1 = "The people's Republic of China"
    val str2 = str1.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "0"
            "e" -> "1"
            "i" -> "2"
            "o" -> "3"
            "u" -> "4"
            else -> it.value
        }
    }
    println(str2)

    "The people's Republic of China".forEach {
        println("$it")
    }
}