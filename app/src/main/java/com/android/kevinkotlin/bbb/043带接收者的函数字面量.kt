package com.android.kevinkotlin.bbb

import java.io.File


/*

带接收者的函数字面量
apply函数是如何做到支持接收者对象的隐式调用的


@kotlin.internal.InlineOnly
public inline fun <T> T.apply(block: T.() -> Unit): T {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    block()
    return this
}


T.() -> Unit
为什么要传入扩展函数（泛型），而不是一个普通的匿名函数？
扩展函数里自带了接收者对象的this隐式调用
为什么是泛型的扩展函数？


匿名函数，也可以是扩展函数
普通的匿名函数
() -> Unit

匿名函数内部this指向一个File对象
 File.() -> Unit


 */


fun main() {
    // File("").apply {
    //     setReadable(true)
    // }
    //
    // val fileExtend: File.() -> Unit = {
    //     setReadable(true)
    // }
    // File("").apply(fileExtend)

    // 步骤分解，方便理解
    fun File.kevin() {
        setReadable(true)
    }

    File("").apply {
        setReadable(true)
    }
}

fun doSomething43(fix: () -> Unit) {

}