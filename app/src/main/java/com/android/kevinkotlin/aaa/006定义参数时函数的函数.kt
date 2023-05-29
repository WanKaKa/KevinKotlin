package com.android.kevinkotlin.aaa

/*


函数的参数是另一个函数


简略的写法
如果一个函数的lambda参数排在最后，或者是唯一的参数，那么括住lambda值参的一对括号就可以省略


 */
/*
fun main() {
    val getDiscountWords = { goodsName: String, hour: Int ->
        val currentYear = 2017
        "${currentYear}年，双11${goodsName}促销倒计时：${hour}小时"
    }
    showOnBoard("卫生纸", getDiscountWords)
}

// 具名函数
fun showOnBoard(goodsName: String, getDiscountWords: (String, Int) -> String) {
    val hour = (1..24).shuffled().last()
    println(getDiscountWords(goodsName, hour))
}

*/

fun main() {
    showOnBoard("卫生纸") { goodsName: String, hour: Int -> "2027年，双11${goodsName}促销倒计时：${hour}小时" }
}

// 具名函数
fun showOnBoard(goodsName: String, getDiscountWords: (String, Int) -> String) {
    val hour = (1..24).shuffled().last()
    println(getDiscountWords(goodsName, hour))
}
