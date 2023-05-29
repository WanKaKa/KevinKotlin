package com.android.kevinkotlin.aaa
/*

lambda可以让你灵活的编写应用，但是，灵活也是要付出代价的

在jvm上，你定义的lambda会以对象实例的形式存在，jvm会为所有同lambda打交道的变量分配内存，这就产生了内存开销。
更糟的是，lambda的内存开销会带来严重的性能问题，幸运的是，kotlin有一种优化机制叫内联，有了内联，jvm就不需要用lambda对象实例了，因而避免了变量内存分配。
哪里需要lambda，编译器就会将函数体复制粘贴到哪里

使用lambda的递归函数无法内联，因为会导致复制粘贴无限循环，编译会发出警告

NDK C语言
预编译指令 宏定义 宏替换

 */
fun main() {

}