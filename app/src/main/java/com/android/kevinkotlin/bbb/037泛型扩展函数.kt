package com.android.kevinkotlin.bbb


/*


泛型扩展函数
新的泛型扩展函数不仅可以支持任何类型的接收者，还保留了接收者的类型信息
使用泛型类型后，扩展函数能够支持更多类型的接收者，适用范围更广了

泛型扩展函数在kotlin标准库里随处可见，
例如let函数，let函数被定义成了泛型扩展函数，所以能支持任何类型，它接受一个lambda表达式，这个lambda表达式接收者T作为值参，
返回R-lambda表达式返回的任何新类型



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


 */

fun String.addExt37(amount: Int = 1) = this + "!".repeat(amount)

fun <T> T.easyPrint37(): T {
    println(this)
    return this
}

fun main() {
    println("abc".addExt37(2))
    println("abc".easyPrint37().addExt37(3))

    "abc".apply { }
}