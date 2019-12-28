package com.yangd.kotlininaction_3.`9_generic`

fun main(args: Array<String>) {
    printContents(listOf("abc", "bac"))

    val strings = mutableListOf("abc","bac")
   // addAnswer(strings)  //Type mismatch. Required: MutableList<Any> Found: MutableList<String>
    println(strings.maxBy { it.length })

}

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
   list.add(42)
}