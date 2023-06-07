package com.android.kevinkotlin.ccc

/*


合并
合并是函数式编程的第三大函数，合并函数能将不同的集合合并成一个新的集合，
这和接收者是包含集合的集合的flatMap函数不同


zip
zip合并函数来合并两个集合，返回一个包含键值对的新集合


fold
另一个可以用来合并值的合并函数fold，这个合并函数接受一个初始累加器值，随后根据匿名函数的结果更新


 */

fun main() {
    val employees = listOf("Jack", "Json", "Tommy")
    val ages = listOf(18, 20, 8)

    println(employees.zip(ages)[0])
    println(employees.zip(ages).toMap()["Jack"])


    val foldValue = listOf(1, 2, 3, 4).fold("") { accumulator, number ->
        accumulator + number * 3
    }
    println(foldValue)
}