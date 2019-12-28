package com.yangd.kotlininaction_3

import java.lang.Appendable
import java.lang.StringBuilder


//， Map 类就有键类型和值类型这两个类型形参：
//class Map<K,V>.我们可以用具体的类型实参来实例化它： Map<String, Person>

//泛型函数有它自己的 类型形参。这些类型形参在每次函数调用时都必须替换成具体的类型实参
fun main(args: Array<String>) {

    println(listOf(1, 2, 3).sum())
    println(oneHalf(3))

    println(max("kotlin", "java"))
//    println(max("kotlin", 42))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)

    val nullableStringProcessor = Processor_<String?>()
    nullableStringProcessor.process(null)
   // val nullableStringProcessor_1 = Processor_1<String?>()
}

//fun <T : Number> List<T>.sum_(): T {
//
//}

fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T)
        where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

class Processor_<T> {
    fun process(value: T) {
        value?.hashCode()
    }
}

class Processor_1<T:Any> {
    fun process(value:T) {
        value.hashCode()
    }
}



