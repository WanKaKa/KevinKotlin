package com.android.kevinkotlin.ccc


/*


map
map变换函数会遍历接收者集合，让变换器函数作用于集合里的每个元素，返回结果是包含已修改元素的集合，
会作为链上下一个函数的输入

可以看到，原始集合没有被修改，map变换函数和你定义的变换器函数做完事情后，返回的是一个新集合，这样，变量就不用变来变去了
事实上，函数式编程范式支持的设计理念就是不可变数据的副本在链上的函数间传递

map返回的集合中的元素个数和输入集合必须一样，不过，返回的新集合里的元素可以是不同类型的

 */



fun main() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
        .map { animal -> "A baby $animal" }
        .map { baby -> "$baby, with the cutest little tail ever!" }
    println(animals)
    println(babies)

    val animalsLength = animals.map { it.length }
    println(animalsLength)
}