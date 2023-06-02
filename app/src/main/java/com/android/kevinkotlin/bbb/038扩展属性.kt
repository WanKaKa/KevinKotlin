package com.android.kevinkotlin.bbb


/*


扩展属性
除了给类添加功能扩展函数外，你还可以给类定义扩展属性，
给String类添加一个扩展，这个扩展属性可以统计字符串里有多少个元音字母


 */

val String.numberVowels
    get() = count { "aeiou".contains(it) }


fun main() {
    "The people's Republic of China".numberVowels.easyPrint37()
}