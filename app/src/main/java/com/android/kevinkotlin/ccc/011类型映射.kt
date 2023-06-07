package com.android.kevinkotlin.ccc

import com.android.kevinlibrary.JavaExample


/*


类型映射
代码运行时，所有的映射类型都会重新映射回对应的java类型


属性访问
不需要调用相关setter方法，你可以使用赋值语法来设置一个java字段值了


 */



fun main() {
    val adversary = JavaExample()
    adversary.hitPoints = 366
    println(adversary.hitPoints)
}