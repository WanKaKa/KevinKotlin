package com.android.kevinkotlin.ccc

/*


过滤
过滤是函数式编程的第二大函数，过滤函数接受一个predicate函数，用它按给定条件检查接收者集合里的元素并给出true或false的判定，
如果predicate函数返回true，受检元素就会添加到过滤函数返回的新集合里，如果predicate函数返回false，那么受检元素就被移出新集合


 */

fun main() {
    val items = listOf(
        listOf("Red apple", "Green apple", "Blue apple"),
        listOf("Red fish", "Blue fish"),
        listOf("Red banana", "Teal banana")
    )

    println(items.flatMap { it -> it.filter { it.contains("Red") } })

    // 找素数
    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = numbers.filter { number ->
        (2 until number).map { number % it }.none { it == 0 }
    }
    println(primes)
}