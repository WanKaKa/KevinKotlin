package com.android.kevinkotlin.ccc


/*


序列
List，Set，Map集合类型，这几个集合类型统称为及早集合（eager collection）
这些集合任何一个实例在创建后，它包含的元素都会被加入并允许你访问。
对应及早集合，kotlin还有另一类集合，惰性集合（lazy collection）类似于类的惰性初始化，
惰性集合类型的性能表现优异，尤其是用于包含大量元素的集合时，因为集合元素是按需产生的


kotlin有个内置惰性集合类型叫序列（Sequence），序列不会索引排序它的内容，也不记录元素数目，事实上，
在使用一个序列时，序列里的值可能有无限多，因为某个数据源能产生无限多个元素

generateSequence
针对某个序列，你可能会定义一个只要序列有新值产生就被调用一下的函数，这样的函数叫迭代器，要定义一个序列和它的迭代器，
你可以使用kotlin的序列构造函数generateSequence，generateSequence函数接受一个初始种子值作为序列的起步值，
在用generateSequence定义的序列上调用一个函数时，generateSequence函数会调用那你指定的迭代器函数，决定下一个要产生的值


 */

fun Int.isPrime(): Boolean {
    // 2 until this 等于 1..this-1
    return (2 until this).map { this % it }.none { it == 0 }
}


fun main() {
    // 惰性集合究竟有什么用呢？为什么要用它而不是List集合呢？假设你想产生头1000个的素数
    // 0-5000之内，可以找到1000个素数
    println((2..5000).filter { it.isPrime() }.take(1000))

    val onThousandPrimes = generateSequence(2) { value ->
        value + 1
    }.filter { it.isPrime() }.take(1000)
    println(onThousandPrimes.toList())
}