package com.android.kevinkotlin.bbb


/*

接口
kotlin规定所有的接口属性和函数实现都要使用override关键字，接口中定义的函数并不需要open关键字修饰，它们默认就是open

 */

interface Movable {

    val maxSpeed: Int
    val wheels: Int
    fun move(movable: Movable): String
}

class Car(_name: String, override var wheels: Int = 4) : Movable {
    override val maxSpeed: Int = 0

    override fun move(movable: Movable): String {
        TODO("Not yet implemented")
    }
}

fun main() {

}