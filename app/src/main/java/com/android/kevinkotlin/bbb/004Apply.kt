package com.android.kevinkotlin.bbb

import java.io.File


/*

可以看到，调用一个个函数类配置接受者时，变量名就省掉了，这是因为，在lambda表达式里，apply能让每个配置函数都作用于接受者
这种行为有时又叫做相关作用域，因为lambda表达式里的所有函数调用都是针对接受者的，或者说，它们是针对接受者的隐式调用

 */


fun main() {
    val file1 = File("C:\\Users\\wankai\\Desktop\\崩坏星穹.txt")
    file1.setReadable(true)
    file1.setWritable(true)
    file1.setExecutable(false)

    val file2 = File("C:\\Users\\wankai\\Desktop\\崩坏星穹.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }
    println(file2)
}