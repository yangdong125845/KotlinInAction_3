package com.yangd.kotlininaction_3.basic_2.func_vatiable

import java.util.*

val question = "The Ultimate Question of Life , the Universe, and Everything"

val answer = 42

val answer1: Int = 42

val yearsToCompute = 7.5e6


fun main(args: Array<String>) {
    val answer2: Int
    answer2 = 0

    val message: String
    if (Random().nextBoolean()) {
        message = "Success"
    } else {
        message = "Failed"
    }

    val languages = arrayListOf("Java")
    languages.add("Kotlin")

    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
    println("Hello ,$name!")

    if (args.isNotEmpty()) {
        println("Hello ,${args[0]} !")
    }

    println("Hello, ${if (args.isNotEmpty()) args[0] else "someone"} !")

}




