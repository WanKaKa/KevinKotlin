package com.android.kevinkotlin.aaa

/*

匿名函数也有类型，匿名函数可以当作变量赋值给函数类型变量，就想其他变量一样，匿名函数就可以在代码里传递了
变量有类型，变量可以等于函数，函数也会有类型，函数的类型，由传入的参数和返回值类型决定

和具名函数不一样，除了极少数情况下，匿名函数不需要return关键字来返回数据，匿名函数会隐式或自动返回函数体最后一行语句的结果


函数参数
和具名函数一样，匿名函数可以不带参数，也可以带一个或多个任何类型的参数，
需要带参数时，参数类型放在匿名函数的类型定义中，参数名则放在函数定义中


 */
fun main() {
    // val total = "Mississippi".count()
    // println(total)
    // val totalS = "Mississippi".count { letter ->
    //     letter == 's'
    // }
    // println(totalS)


    // 变量的类型是一个匿名函数
    // 传入值无 返回值String
    // val blessingFunction: () -> String
    // blessingFunction = {
    //     val holiday = "New Year."
    //     "Happy $holiday"
    // }


    // val blessingFunction: (String) -> String = { name ->
    //     val holiday = "Ney Year."
    //     "$name, Happy $holiday"
    // }
    //
    // println(blessingFunction("Jack"))
}