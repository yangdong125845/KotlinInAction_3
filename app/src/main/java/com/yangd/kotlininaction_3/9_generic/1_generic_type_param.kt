package com.yangd.kotlininaction_3.`9_generic`


//， Map 类就有键类型和值类型这两个类型形参：
//class Map<K,V>.我们可以用具体的类型实参来实例化它： Map<String, Person>

//泛型函数有它自己的 类型形参。这些类型形参在每次函数调用时都必须替换成具体的类型实参
fun main(args: Array<String>) {
    val authors = listOf("Dmitry", "Svetlana")

    val readers: MutableList<String> = mutableListOf()
    val readers_ = mutableListOf<String>()

    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))
    println(letters.slice(10..13))

    readers.filter { it !in authors }

    println(listOf(1, 2, 3, 4).penultimate_)

}

val <T> List<T>.penultimate_: T
    get() = this[size - 2]

//fun <T> List<T>.slice_1(indices: IntRange): List<T> {
//
//}

//fun <T> List<T>.filter_(predicate:(T) -> Boolean) :List<T> {
//
//}


//如果你的类继承了泛型类（或者实现了泛型接口），你就得为基础类型的泛型形参提供 个类型实参,
// 它可以是具体类型或者另 个类型形参
interface List_<T> {
    operator fun get(index: Int): T
}

class StringList_ : List_<String> {
    override fun get(index: Int): String {
        return ""
    }
}

class ArrayList_<T> : List_<T> {  // 现在ArrayList_的泛型类型形参T 就是List_的类型实参
    override fun get(index: Int): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

interface Comparable_<T> {
    fun compareTo(other: T): Int
}

class String_:Comparable_<String> {
    override fun compareTo(other: String): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

