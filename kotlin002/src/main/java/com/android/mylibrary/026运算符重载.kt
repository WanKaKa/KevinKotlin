package com.android.mylibrary


/*

+ plus 把一个对象添加到另一个对象里

+= plusAssign 把一个对象添加到另一个对象里，然后将结果赋值给第一个对象

== equals 如果两个对象相等，则返回true，否则返回false

> compareTo 如果左边大于右边的对象，，则返回true，否则返回false

[] get 返回集合中指定位置的元素

.. rangTo 创建一个rang对象

in contains 如果对象包含在集合里，则返回true



 */


data class Coordinate26(var x: Int, var y: Int) {
    val isInBounds = x > 0 && y > 0

    operator fun plus(other: Coordinate26) = Coordinate26(x + other.x, y + other.y)
}


fun main() {
    val c1 = Coordinate26(10, 20)
    val c2 = Coordinate26(10, 20)

    println(c1 + c2)
}