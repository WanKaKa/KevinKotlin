package com.android.mylibrary


/*

密封类
对于更复杂的ADT，你可以使用kotlin的密封类（sealed class）来实现更复杂的定义
密封类可以用来定义一个类似枚举类的ADT，但你可以更灵活的控制某个子类型

密封类可以有若干个子类，要继承密封类，这些子类必须和它定义在同一个文件里

 */





sealed class LicenseStatus29 {

    // 这里使用object是因为实例化100个对象都是一样的，也可以写成class
    object Unqualified : LicenseStatus29()
    object Learning : LicenseStatus29()
    class Qualified(val licenseId: String) : LicenseStatus29()
}


class Driver29(private val state: LicenseStatus29) {
    fun checkLicense(): String {
        return when (state) {
            is LicenseStatus29.Unqualified -> "没资格"
            is LicenseStatus29.Learning -> "学习中"
            is LicenseStatus29.Qualified -> "有资格 驾驶证编号${this.state.licenseId}"
        }
    }
}


fun main() {
    println(Driver29(LicenseStatus29.Qualified("9527")).checkLicense())
    println(Driver29(LicenseStatus29.Learning).checkLicense())
}