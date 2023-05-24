package com.android.mylibrary


/*

嵌套类
如果一个类只对另一个类有用，那么将其嵌入到该类中并使用这两个类保持在一起是合乎逻辑的，可以使用嵌套类

 */


class Player22 {
    class Equipment(var name: String) {
        fun show() = println("Equipment:$name")
    }

    fun battle() {
    }
}

fun main() {
    Player22.Equipment("Sharp knife").show()
}