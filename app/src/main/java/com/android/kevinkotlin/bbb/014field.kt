package com.android.kevinkotlin.bbb

import java.util.*


/*

field

针对你定义的每一个属性，kotlin都会产生一个field，一个getter以及一个setter，field用来存储属性数据，
不能直接定义field，kotlin会封装field只暴露getter和setter使用


属性的getter方法决定你如何读取属性值，每个属性都有getter方法。setter方法决定你如何给属性赋值，所以只有可变属性才会有setter方法，
尽管kotlin会自动提供默认的getter和setter方法，但在需要控制如何读写属性数据时，你也可以自定义他们


计算属性是通过一个覆盖的get或set运算符来定义，这时field就不需要了



 */

class Player {
    var name: String = "Jack"
        get() = field.capitalize(Locale.ROOT)
        set(value) {
            field = value.trim()
        }
}

fun main() {
    var p = Player()
    p.name = "   rose"
    println(p.name)
}

