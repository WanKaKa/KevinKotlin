package com.android.kevinkotlin.bbb

fun main() {
    // val file1 = File("C:\\Users\\wankai\\Desktop\\崩坏星穹.txt")
    // val result = file1.run {
    //     readText().contains("克拉拉")
    //     "The people's Republic of China"
    // }
    // println(result)

    // val result2 = "The people's Republic of China".run(::isLong)
    // println(result2)


    // isLong("The people's Republic of China")

    val result3 = "The people's Republic of China"
        .run(::isLong)
        // .run { showMessage2(this) }
        // .run(::showMessage2)
        .run {
            { name: String ->
                "$name " + (if (this) "字符大于等于10个" else "字符小于10个")
            }
        }
        .run { println(this("WanKai")) }
    println(result3)
}

// fun isLong(name: String) {
//     name.length >= 10
// }

fun isLong(name: String): Boolean {
    return name.length >= 10
}

fun showMessage(isLong: Boolean): String {
    return if (isLong) "Name is too long" else "Please rename"
}

fun showMessage2(isLong: Boolean): (String) -> String {
    return {
        "$it " + (if (isLong) "字符大于等于10个" else "字符小于10个")
    }
}