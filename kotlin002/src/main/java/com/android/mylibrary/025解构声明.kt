package com.android.mylibrary


/*

解构声明

解构声明的后台实现就是声明 component1，component2 等若干个组件函数，
让每个函数负责管理你想返回的一个属性数据，如果你定义一个数据类，它会自动为所有定义在主构造函数的属性添加对应的主件函数

 */


//class PlayerScore(val experience: Int, val level: Int) {
//    operator fun component1() = experience
//    operator fun component2() = level
//}

data class PlayerScore(val experience: Int, val level: Int) {
}


fun main() {
    val (x, y) = PlayerScore(10, 20)
    println(x)
    println(y)
}