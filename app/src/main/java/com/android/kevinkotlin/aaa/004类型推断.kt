package com.android.kevinkotlin.aaa

/*


类型推断也支持带参数的匿名函数，但是为了帮助编译器更准确的推断变量类型，匿名函数的参数名和参数类型必须有


 */
fun main() {
//    val blessingFunction = {
//        val holiday = "Ney Year."
//        " Happy $holiday"
//    }
//
//    println(blessingFunction())


    val blessingFunction = { name: String, year: Int ->
        val holiday = "Ney Year."
        "$name, Happy $holiday $year"
    }
    println(blessingFunction("Jack", 2027))
}