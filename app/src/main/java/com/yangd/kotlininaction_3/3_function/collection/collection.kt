package com.yangd.kotlininaction_3.`3_function`.collection

fun main(args: Array<String>) {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    val strings = listOf("first", "second", "fourteenth")

    println(strings.last())
    val numbers = setOf(1, 14, 2)
    println(numbers.max())
}