package com.android.mylibrary


/*


with函数是run的变体，他们的功能行为是一样的，但是with的调用方式不同，调用with需要值参作为其第一个参数传入


 */
fun main() {
    val result = "The people's Republic of China".run {
        length >= 10
    }
    println(result)

    val result2 = with("The people's Republic of China") {
        length >= 10
    }
    println(result2)
}