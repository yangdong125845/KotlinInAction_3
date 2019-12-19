package com.yangd.kotlininaction_3.function_3.hand_collection

fun main(args: Array<String>) {
    val strings: List<String> = listOf("first", "second", "fourteenth")
    strings.last()

    val numbers: Collection<Int> = setOf(1, 14, 2)
    numbers.max()

    val list = listOf("args: ", *args)
    println(list)

    val map = mapOf(1 to "one", 7 to "seven",53 to "fifty-three")

    val (number ,name) = 1 to "one"
}