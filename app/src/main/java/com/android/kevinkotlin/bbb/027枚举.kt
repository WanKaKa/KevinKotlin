package com.android.kevinkotlin.bbb


/*

枚举类

枚举类也可以定义函数

 */

data class Coordinate27(var x: Int, var y: Int) {
    val isInBounds = x > 0 && y > 0

    operator fun plus(other: Coordinate26) = Coordinate26(x + other.x, y + other.y)
}

enum class Direction(private val coordinate: Coordinate27) {
    East(Coordinate27(1, 0)),
    West(Coordinate27(0, 1)),
    South(Coordinate27(1, 1)),
    North(Coordinate27(0, 0));

    fun updateCoordinate(playerCoordinate: Coordinate27) =
        Coordinate27(playerCoordinate.x + coordinate.x, playerCoordinate.y + coordinate.y)
}


fun main() {
    println(Direction.East)
//    println(Direction.East is Direction)
    println(Direction.West.updateCoordinate(Coordinate27(10, 20)))
}