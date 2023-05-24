package com.android.mylibrary

import java.io.File


/*

继承
类默认都是关闭的，要让某个类开放继承，必须是使用open关键字修饰

 */

open class Product(open val name: String) {

    fun description() = "Product: $name"

    open fun load() = "Nothing..."
}

class LuxuryProduct(override val name: String) : Product("Jack") {
    override fun load() = "LuxuryProduct loading..."

    fun special() = "LuxuryProduct special function"
}

fun main() {
    val p: Product = LuxuryProduct("Jimmy")
    println(p.description())

//    println(p is Product)
    println(p is LuxuryProduct)
    println(p is File)

    println((p as LuxuryProduct).special())
    // 智能类型转换
    println(p.special())
}