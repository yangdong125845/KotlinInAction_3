package com.yangd.kotlininaction_3.basic_2.select

import java.lang.IllegalArgumentException

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun main(args: Array<String>) {

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

    println(evalIf(Sum(Num(1), Num(2))))

    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))

}

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }

    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }

    throw IllegalArgumentException("Unknown expression")
}

fun evalIf(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        evalIf(e.right) + evalIf(e.left)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }

fun evalWhen(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> evalWhen(e.right) + evalWhen(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sun: $left + $right")
            left + right
        }
        else -> throw  IllegalArgumentException("Unknown expression")
    }