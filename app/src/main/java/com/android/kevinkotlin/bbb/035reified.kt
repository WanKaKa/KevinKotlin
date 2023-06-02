package com.android.kevinkotlin.bbb

/*

reified
有时候，你可能想知道某个泛型参数具体是什么类型，reified关键字能帮你检查泛型参数类型
kotlin不允许对泛型参数T做类型检查，因为泛型参数类型会被类型擦除，也就是说，T的类型信息在运行时是不可知的，java也有这样的规则

关键字 reified inline

 */


open class Human35(val age: Int)

class Boy35(val name: String, age: Int) : Human35(age) {
    override fun toString(): String {
        return "Boy(name = $name, age = $age)"
    }
}

class Man35(val name: String, age: Int) : Human35(age) {
    override fun toString(): String {
        return "Man(name = $name, age = $age)"
    }
}

class MagicBox35<T> {

    val humanList = listOf(
        Boy35("YuKi", 15),
        Man35("Jack", 38)
    )

    fun randomOrBackup(human: T, backup: () -> T): T {
        return human ?: backup()
    }

    inline fun <reified T> randomOrBackupEx(backup: () -> T): T {
        val random = humanList.shuffled().first()
        return if (random is T) random else backup()
    }
}

fun main() {
    val box = MagicBox35<Human35>()
    println(box.randomOrBackup(Man35("Jimmy", 45)) {
        Man35("Jimmy", 45)
    })

    val value = box.randomOrBackupEx {
        Man35("Jimmy", 45)
    }
    println(value)
}