package com.android.mylibrary


/*


延时初始化
使用 lateinit 关键字相当于一个约定，在用它之前负责初始化
只要无法确认 lateinit 变量是否完成初始化，可以执行 isInitialized 检查



 */

class Player4 {
    lateinit var equipment: String

    fun ready() {
        equipment = "sharp knife"
    }

    fun battle() {
        if (::equipment.isInitialized) println(equipment)
    }
}


fun main() {
    val player4 = Player4()
    player4.ready()
    player4.battle()
}