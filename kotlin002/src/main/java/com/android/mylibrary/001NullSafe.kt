package com.android.mylibrary

import java.util.*


/*


kotlin的null类型


null安全

kotlin区分可空类型和非可空类型，所以，你要一个可空类型变量运行时，而它可能不存在，对于这种潜在危险，编译器时刻警惕着。
为了应对这种风险，kotlin不允许你在可空类型上调用函数，除非你主动接手安全管理



选项一：安全调用操作符
这次kotlin不报错了，编译器看到有安全调用操作符，所以他知道如何检查null值
如果遇到null值，他就跳过函数调用，而不是返回null



使用带let的安全调用
安全调用允许在可空类型上调用函数，但是如果还想做点额外的事，比如创建新值，或判断不为null就调用其他函数，怎么办？
可以使用let函数的安全操作符。你可以在任何类型上调用let函数，他的主要作用是让你在指定的作用域内定义一个或多个变量
返回的值是代码最后一行代码的执行结果



 选项二：使用非空断言操作符
 !!.又称感叹号操作符，当变量为null时，会抛出KotlinNullPointerException



使用空合并操作符
?:操作符的意思是，如果左边的求值结果为null，就是用右边的结果值


先决条件函数
kotlin标准库提供了一些便利函数，使用这些内置函数，你可以抛出自定义信息的异常，这些便利函数叫做先决条件函数，
你可以用它定义先决条件，条件必须满足，目标代码才能执行

 */



fun main() {
    /**
     * ?代表可以为空
     */
//    var str: String? = "butterfly"
////    str = null
//    println(str?.capitalize())


//    var str: String? = "butterfly"
////    str = ""
//    str = str?.let {
//        if (it.isNotBlank()) {
//            it.capitalize(Locale.ROOT)
//        }else{
//            "butterfly"
//        }
//    }
//    println(str)


//    var str: String? = "butterfly"
////    str = null
//    println(str!!.capitalize())


//    var str: String? = "butterfly"
////    str = null
//    str?.capitalize().plus("Great")


    var str: String? = "butterfly"
    str = null
//    str = str ?: "A"
    println(str?.capitalize(Locale.ROOT))
}















