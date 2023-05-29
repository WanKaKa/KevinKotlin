package com.android.kevinkotlin.aaa

/*

函数类型也是有效的返回类型，也就是说可以定义一个能返回函数的函数

 */
fun main() {
    val getDiscountWords = configDiscountWords()
    print(getDiscountWords("牙膏"))
}

fun configDiscountWords(): (String) -> String {
    val currentYear = 2027
    val hour = (1..24).shuffled().last()
    return { goodsName: String ->
        "${currentYear}年，，双11${goodsName}促销倒计时：$hour 小时"
    }
}