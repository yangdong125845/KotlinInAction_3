package com.yangd.kotlininaction_3._6_class_system._3

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException

fun main(args: Array<String>) {

    for (i in args.indices) {
        println("Argument $i is: ${args[i]}")
    }
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)

    val source = arrayListOf(3, 5, 7)
    val target: MutableCollection<Int> = arrayListOf(1)
    val target_1: Collection<Int> = arrayListOf(1)
//    copyElements(source,target_1)
    copyElements(source, target)
    println(target)

    val letters = Array<String>(26) { i ->
        ('a' + i).toString()
    }
    println(letters.joinToString(" "))

    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))

    val fiveZeros = IntArray(5)
    val fiveZerosToo = intArrayOf(0, 0, 0, 0, 0)
    val sequares = IntArray(5) { i -> (i + 1) * (i + 1) }
    println(sequares.joinToString())

    args.forEachIndexed { index, element ->
        println("Argument $index is: $element")
    }
}

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        } catch (e: NumberFormatException) {
            result.add(null)
        }
    }
    return result
}

fun addValidNumbers(numbers: List<Int?>) {
    var sumOdValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {
        if (number != null) {
            sumOdValidNumbers += number
        } else {
            invalidNumbers++
        }
    }
    println("Sum of valid numbers: $sumOdValidNumbers")
    println("Invalid numbers $invalidNumbers")
}

fun addValidNumbers_filter(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun <T> copyElements(
    source: Collection<T>,
    target: MutableCollection<T>
) {
    for (item in source) {
        target.add(item)
    }
}