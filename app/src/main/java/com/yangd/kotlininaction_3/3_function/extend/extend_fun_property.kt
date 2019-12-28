package com.yangd.kotlininaction_3.`3_function`.extend

import java.lang.StringBuilder

fun String.lastChar(): Char = this.get(this.length - 1)

fun String.lastChar1(): Char = get(length - 1)

fun main(args: Array<String>) {
    println("Kotlin".lastChar())

    val list = listOf(1, 2, 3)
    println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))
    println(listOf("one", "two", "eight").join(" "))

    val view: View = Button()
    view.click()

    val view1: View = Button()
    view1.showOff()

    println("Kotlin".lastChar1)
    val sb = StringBuilder("Kotlin?")
    sb.lastChar2= '!'
    println(sb)
}

fun <T> Collection<T>.joinToString(
    serparator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(serparator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button")

val String.lastChar1: Char
    get() = get(length - 1)

var StringBuilder.lastChar2: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }