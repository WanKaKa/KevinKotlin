package com.android.mylibrary


/*

代数数据类型

可以用来表示一组子类型的闭集，枚举类就是一种简单的ADT


 */



enum class LicenseStatus {
    Unqualified,
    Learning,
    Qualified
}


class Driver(private val state: LicenseStatus) {
    fun checkLicense(): String {
        return when (state) {
            LicenseStatus.Unqualified -> "没资格"
            LicenseStatus.Learning -> "学习中"
            LicenseStatus.Qualified -> "有资格"
        }
    }
}


fun main() {
    println(Driver(LicenseStatus.Qualified).checkLicense())
}