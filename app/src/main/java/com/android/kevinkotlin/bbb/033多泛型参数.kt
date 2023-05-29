package com.android.kevinkotlin.bbb


/*

泛型函数或泛型类也可以有多个泛型参数


泛型类型约束



vararg 可变参数

 */


class MagicBox33<T>(item: T) {

    var available = false
    private val subject: T = item

    fun fetch(): T? {
        return subject.takeIf { available }
    }

    /*
     * 业务 把元素进行修改
     * 魔盒里面放的是男孩，取出来的时候，我给他改成了一个男人
     * return -> R
     */
    fun <R> fetch(subjectModFunction: (T) -> R): R? {
        return subjectModFunction(subject).takeIf { available }
    }
}

class Boy33(val name: String, val age: Int) {

}

class Man33(val name: String, val age: Int) {

}

class Dog33(val weight: Int) {

}

fun main() {
    val box1 = MagicBox33(Boy33("Jack", 20))
    val box2 = MagicBox33(Dog33(20))
    box1.available = true
    println(box1.fetch()?.name)
    println(box2.fetch()?.weight)

    box1.fetch()?.run {
        println("You find $name")
    }

    box1.fetch {
        Man33(it.name, it.age.plus(15))
    }
}