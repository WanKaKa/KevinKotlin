package com.android.kevinkotlin.bbb


/*


out 协变
如果泛型只能将泛型类型作为函数的返回（输出），
那么使用out，可以称之为生产类/接口，因为它主要是用来生产produce指定的泛型对象


in 逆变
如果泛型类只能将泛型类型作为函数的入参（输入），
那么使用in，可以称之为消费者类/接口，因为它主要是用来消费（consume）指定的泛型对象


为什么使用in&out
举个例子，我们定义下汉堡类对象，他是有一种快餐，也是一种食物


子类泛型对象可以赋值给父类分型对象，用out
父类泛型对象可以赋值给子类泛型对象，用in


 */

// out 协变
interface Production<out T> {
    fun product(): T
}

// in 逆变
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

// 消费者
// 任何人 食物都会吃
class Everybody : Consumer<Food> {

    override fun consume(item: Food) {
        println("Eat Food")
    }
}

// 现代人吃快餐
class ModernPeople : Consumer<FastFood> {
    override fun consume(item: FastFood) {
        println("Eat FastFood")
    }
}

// 美国人吃汉堡
class American : Consumer<Burger> {
    override fun consume(item: Burger) {
        println("Eat Burger")
    }
}

fun main() {
    // 子类泛型对象可以赋值给父类分型对象，用out
    val production1: Production<Food> = FoodStore()
    val production2: Production<Food> = FastFoodStore()
    val production3: Production<FastFood> = FastFoodStore()
    val production4: Production<Burger> = BurgerFoodStore()

    // 父类泛型对象可以赋值给子类泛型对象，用in
    val consume1: Consumer<Food> = Everybody()
    consume1.consume(production1.product())

    val consume2: Consumer<Burger> = Everybody()
    consume2.consume(production4.product())

    Everybody().consume(production2.product())
    ModernPeople().consume(production3.product())
    American().consume(production4.product())
}