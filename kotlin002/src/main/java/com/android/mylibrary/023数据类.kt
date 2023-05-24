package com.android.mylibrary


/*

数据类

数据类，是专门设计用来存储数据的类
数据类提供了toString个个性话实现
==符号默认情况下，比较对象就是比较他们的引用值，数据类提供了equals和hashCode的个性化实现



使用数据类的条件
数据类必须至少带一个参数的主构造函数
数据类主构造函数的参数必须是val或var
数据类型不能使用 abstract，open，sealed，inner 修饰符
 */


data class Coordinate(var x: Int, var y: Int) {
    val isInBounds = x > 0 && y > 0
}


fun main() {
    println(Coordinate(10, 20))
    println(Coordinate(10, 20) == Coordinate(10, 20))
}