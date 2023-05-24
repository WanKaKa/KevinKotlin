package com.android.mylibrary

import java.util.*
import kotlin.math.absoluteValue


/*


主构造函数
我们在Player类的定义中定义一个主构造函数，使用临时变量为Player的各个属性提供初始值，在kotlin中，为便于识别，
临时变量（包括仅引用一次的参数），通常都会以下划线开头的名字命名


初始化块
初始化块可以设置变量或值，以及执行有效性检查，如检查传给某构造函数的值是否有效，初始化块代码会在构造类实例时执行

 */


open class Player2(_name: String, _age: Int, _isNormal: Boolean) {
    private val name = _name
        get() = field.capitalize(Locale.ROOT)
    private val age = _age
        get() = field.absoluteValue
    private val isNormal = _isNormal

    init {
        require(age > 0) {
            "Age must be positive"
        }
        require(name.isNotBlank()) {
            "Player must have a name"
        }
    }

    override fun toString(): String {
        return "Age = $age, Name = $name, Normal = $isNormal"
    }
}


fun main() {
    val p = Player2("Jack", 12, true)
    println(p)
}