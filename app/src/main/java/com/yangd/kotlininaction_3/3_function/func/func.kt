@file:JvmName("Functions")

/**
 * public class Functions{
 * public static String joinToString(...) {...}
 * }
 *
 * Functions.joinToString(list,", ","","")
 */

/**
 * 如果没有这个@file:JvmName
 *
 * public class FuncKt{
 * public static String joinToString(...) {...}
 * }
 *
 * FuncKt.joinToString(list,", ","","" )
 */

package com.yangd.kotlininaction_3.`3_function`.func

import java.lang.StringBuilder

const val UNIX_LINE_SEPARATOR = "\n"  // public static final String UNIX_LINE_SEPARATOR = "\n"

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    println(list)
    println(joinToString(list, "; ", "(", ")"))
    joinToString(list, separator = " ", prefix = " ", postfix = ".")

    joinToString1(list, ", ", "", "")
    joinToString1(list)
    joinToString1(list, "; ")
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun <T> joinToString1(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

var opCount = 0

fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    println("Operation performed $opCount times")
}




