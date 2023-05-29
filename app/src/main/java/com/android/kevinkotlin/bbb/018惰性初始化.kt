package com.android.kevinkotlin.bbb


/*


惰性初始化
延迟初始化并不是推后初始化的唯一方式，你也可以暂时不初始化某个变量，
直到首次调用它，这个叫惰性初始化


 */

class Player5(_name: String) {
    var name = _name

    val config by lazy { loadConfig() }

    //        val config = loadConfig()
    private fun loadConfig(): String {
        println("Loading")
        return "xxx"
    }
}

open class Player6(_name: String) {

    private val name: String = _name
    val playerName: String = initPlayerName()

    open fun initPlayerName(): String {
        return name
    }
}

fun main() {
    val player5 = Player5("Jack")
    Thread.sleep(3000)
    println(player5.config)

//    println(Player6("Jack").playerName)
}