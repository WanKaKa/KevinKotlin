package com.android.kevinkotlin.bbb


/*



 */


data class Student24(val _name: String, val age: Int) {

    val name = _name
    var score = 10
    val hobby = "Music"
    val subject: String

    init {
        println("initializing student...")
        subject = "Math"
    }

    // 次构造函数
    constructor(_name: String) : this(_name, 10) {
        score = 20
    }

    override fun toString(): String {
        return "Student24(_name='$_name', age=$age, name='$name', score=$score, hobby='$hobby', subject='$subject')"
    }


}

fun main() {
    val s = Student24("Jack")
    val ss = s.copy(_name = "Rose", age = 36)

    println(s)
    println(ss)
}