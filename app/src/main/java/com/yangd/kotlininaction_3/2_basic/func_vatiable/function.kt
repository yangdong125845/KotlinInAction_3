package com.yangd.kotlininaction_3.`2_basic`.func_vatiable

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max1(a: Int, b: Int): Int = if (a > b) a else b

fun max2(a: Int, b: Int) = if (a > b) a else b