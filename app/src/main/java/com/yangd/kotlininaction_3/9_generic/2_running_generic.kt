package com.yangd.kotlininaction_3.`9_generic`

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import java.lang.IllegalArgumentException
import java.util.*

fun main(args: Array<String>) {

    printSum(listOf(1, 2, 3))
    // printSum(setOf(1, 2, 3))   //java.lang.IllegalArgumentException: List is expected
//    printSum(
//        listOf(
//            "a",
//            "b",
//            "c"
//        )
//    )   //java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Number

    printSum_(listOf(1, 2, 3))
    printSum_(setOf(1, 2, 3))

    println(isA<String>("abc"))
    println(isA<String>(123))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())

    val serviceImpl = ServiceLoader.load(Service::class.java)
    val serviceImpl_ = loadService<Service>()


}

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int>
        ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

fun printSum_(c: Collection<Int>) {
    if (c is List<Int>) {
        println(c.sum())
    }
}

// fun <T> isA(value:Any) = value is T  //Cannot check for instance of erased type: T

inline fun <reified T> isA(value: Any) = value is T

inline fun <reified T> Iterable<*>.filterIsInstance_(): List<T> {
    val destination = mutableListOf<T>()
    for (element in this) {
        if (element is T) {
            destination.add(element)
        }
    }
    return destination
}


inline fun <reified T> loadService(): ServiceLoader<T>? {
    return ServiceLoader.load(T::class.java)
}

inline fun <reified T:Activity> Context.startActivity() {
    val intent = Intent(this,T::class.java)
    startActivity(intent)
}