package com.yangd.kotlininaction_3.`9_generic`

import com.yangd.kotlininaction_3._6_class_system._3.copyElements

fun main(args: Array<String>) {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
    copyData_(ints, anyItems)
    println(anyItems)

//    val list:MutableList<out Number>
//    list.add(42)




}

interface Producer<out T> {
    fun produce(): T

}

fun <T> copyData(
    source: MutableList<T>,
    destination: MutableList<T>
) {
    for (item in source) {
        destination.add(item)
    }
}

fun <T : R, R> copyData_(
    source: MutableList<T>,
    destination: MutableList<R>
) {
    for (item in source) {
        destination.add(item)
    }
}

fun <T> copyData_2(
    source: MutableList<out T>,
    destination: MutableList<T>
) {
    for (item in source) {
        destination.add(item)
    }
}