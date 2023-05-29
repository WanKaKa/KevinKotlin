package com.android.kevinkotlin.bbb


/*

定义泛型类

泛型类的构造函数可以接受任何类型

MagicBox类指定的泛型参数放在一对<>里的字母T表示，T是个代表item类型的占位符
MagicBox类接受任何类型的item作为主构造函数(item:T)，并将item值赋给同样是T类型的subject私有属性


泛型参数通常用字母T（代表英文type）表示，当然，想用其他字母，甚至是英文单词都是可以的，
不过，其他支持泛型的语言都在用这个预定俗成的T，所以建议你继续用它，这样写出的代码别人更容易理解
 */

class MagicBox<T>(item: T) {

    var available = false
    private val subject: T = item

    fun fetch(): T? {
        return subject.takeIf { available }
    }
}

class Boy(val name: String, val age: Int) {

}

class Dog(val weight: Int) {

}

fun main() {
    val box1 = MagicBox(Boy("Jack", 20))
    val box2 = MagicBox(Dog(20))
    box1.available = true
    println(box1.fetch()?.name)
    println(box2.fetch()?.weight)

    box1.fetch()?.run {
        println("You find $name")
    }
}