package com.android.mylibrary

/*

kotlin层次

无须在代码里显示指定，每一个类都会继承一个公同的叫做Any的超类

 */


open class Product2(open val name: String) {

    fun description() = "Product: $name"

    open fun load() = "Nothing..."
}

class LuxuryProduct2(override val name: String) : Product2("Jack") {
    override fun load() = "LuxuryProduct loading..."

    fun special() = "LuxuryProduct special function"
}

fun main() {
    val p: Product2 = LuxuryProduct2("Jimmy")
    println(p.description())

//    println(p is Product)
    println(p is LuxuryProduct2)
    println(p.toString())
}