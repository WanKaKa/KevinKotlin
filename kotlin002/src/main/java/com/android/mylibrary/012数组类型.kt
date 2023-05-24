package com.android.mylibrary

import java.io.File


/*


kotlin提供各种array，虽然是引用类型，但可以编译成java基本数据类型


 */


fun main() {
    val intArrayOf = intArrayOf(10, 30, 40)
    listOf(10, 30, 40).toIntArray()
    val arrayOf = arrayOf(File(""), File(""))
}