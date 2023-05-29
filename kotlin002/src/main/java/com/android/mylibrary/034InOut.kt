package com.android.mylibrary

/*


out 协变
如果泛型只能将泛型类型作为函数的返回（输出），
那么使用out，可以称之为生产类/接口，因为它主要是用来生产produce指定的泛型对象


in 逆变
如果泛型类只能将泛型类型作为函数的入参（输入），
那么使用in，可以称之为消费者类/接口，因为它主要是用来消费（consume）指定的泛型对象


为什么使用in&out
举个例子，我们定义下汉堡类对象，他是有一种快餐，也是一种食物


 */

// out 协变
interface Production<out T> {
    fun product(): T
}

// in
interface Consumer<in T> {
    fun consume(item: T)
}

// 不变
interface ProductionConsumer<T> {
    fun product(): T
    fun consume(item: T)
}

open class Food

open class FastFood : Food()

open class Burger : FastFood()

// 食品商店
class FoodStore : Production<Food> {

    override fun product(): Food {
        println("Product Food")
        return Food()
    }
}

// 快餐商店
class FastFoodStore : Production<FastFood> {

    override fun product(): FastFood {
        println("Product FastFood")
        return FastFood()
    }
}

// 汉堡商店
class BurgerFoodStore : Production<Burger> {

    override fun product(): Burger {
        println("Product Burger")
        return Burger()
    }
}

fun main() {
    val production1: Production<Food> = FoodStore()
    val production2: Production<Food> = FastFoodStore()
}