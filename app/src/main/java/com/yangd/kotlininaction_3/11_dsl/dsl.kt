package com.yangd.kotlininaction_3.`11_dsl`

import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = buildString {
        it.append("Hello, ")
        it.append("World!")
    }
    println(s)

    val s1 = buildString_1 {
        this.append("Hello, ")
        append("World!")
    }
    println(s1)

    val appendExc1: StringBuilder.() -> Unit =
        { this.append("!") }
    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExc1()
    println(stringBuilder)
    println(buildString(appendExc1))

    val map = mutableMapOf(1 to "One")
    map.apply { this[2] = "two" }
    with(map) {this[3] = "three"}
    println(map)
}

fun buildString(
    builderAction: (StringBuilder) -> Unit
): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

fun buildString_1(
    builderAction: StringBuilder.() -> Unit
): String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

fun buildString_2(builderAction: StringBuilder.() -> Unit): String =
    StringBuilder().apply(builderAction).toString()

inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}

inline fun <T, R> with(receiver: T, block: T.() -> R): R =
    receiver.block()