package com.android.kevinkotlin.bbb


/*


初始化顺序
1. 主构造函数里声明的属性
2. 类级别的属性赋值
3. init初始化块里的属性赋值和函数调用
4. 次构造函数里的属性赋值和函数调用


 */

class Student(_name: String, val age: Int) : Player2(_name, 12, false) {
    var name = _name
    var score = 10
    private val hobby = "Music"
    val subject: String

    init {
        println("initializing student...")
        subject = "Math"
    }

    constructor(_name: String) : this(_name, 10) {
        score = 20
    }
}


fun main() {
    println(Student("Jack"))
}