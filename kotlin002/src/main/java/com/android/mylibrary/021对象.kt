package com.android.mylibrary

import java.io.File

/*

object关键字
使用object关键字，你可以定义一个只能产生一个实例的类-单例
使用object关键字有三种方式
对象声明
对象表达式
伴生对象




对象声明
对象声明有利于组织代码和管理状态，尤其是管理整个应用运行生命周期内的某些一致性状态



对象表达式
有时候你不一定非要定义一个新的命名类不可，也许你需要某个现有类的一种变体实例
但只需用一次就行了，事实上，对于这种用完就丢的类的实例，连命名都可以省了。
这个对象表达式是XX的子类，这个匿名类依然遵循object关键字的一个规则，即一旦实例化，该匿名类只能有唯一一个实例存在



伴生对象
如果你想将某个对象的初始化和一个类实例捆绑在一起，可以考虑使用伴生对象，使用companion修饰符，你可以在一个类定义里声明一个伴生对象
一个类只能有有一个伴生对象

 */


object ApplicationConfig {
    init {
        println("ApplicationConfig loading...")
    }

    fun doSomething() {
        println("doSomething")
    }
}


open class ConfigMap() {

    // 也是单例
    companion object {

        private const val Path = ""

        fun load() = File(Path).readBytes()
    }
}

object ConfigMap2 {

    private const val Path = ""

    val name: String
        get() {
            return "Jack"
        }

    fun load() = File(Path).readBytes()
}


fun main() {
    // 类名 实例名
//    println(ApplicationConfig.doSomething())

    val p = object : Player6("Jack") {
        override fun initPlayerName(): String {
            return "NuLiBa"
        }
    }
    println(p.playerName)

    println(ConfigMap2.name)
}