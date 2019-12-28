package com.yangd.kotlininaction_3.`8_supper_func_lambda`

import java.lang.StringBuilder

fun main(args: Array<String>) {

    val sum = { x: Int, y: Int -> x + y }
    val action = { println(42) }

    val _sum: (Int, Int) -> Int = { x, y -> x + y }
    val _action: () -> Unit = { println(42) }

    var canReturnNull: (Int, Int) -> Int? = { _, _ -> null }

    var funOrNull: ((Int, Int) -> Int)? = null

    val url = "http://kotl.in"
    performRequest(url) { code, content -> }
    performRequest(url) { code, page -> }

    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }

    println("ab1c".filter { it -> it in 'a'..'z' })
    println("ab1c".filter {  it in 'a'..'z' })
}

fun performRequest(
    url: String,
    callback: (code: Int, content: String) -> Unit
) {

}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}