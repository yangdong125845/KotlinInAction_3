package com.yangd.kotlininaction_3.`2_basic`.exception

import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun main(args: Array<String>) {
    val number = if (args.isNotEmpty()) args[0].toInt() else 0
    val percentage =
        if (number in 0..100)
            number
        else
            throw  IllegalArgumentException(
                "" +
                        "A percentage value must be between 0 and 100 : $number"
            )

    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
    val reader1 = BufferedReader(StringReader("not a number"))
    readNumber1(reader1)
    val reader2 = BufferedReader(StringReader("not a number"))
    readNumber2(reader2)
}

fun  readNumber(reader:BufferedReader) :Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }catch (e:NumberFormatException) {
        return null
    }finally {
        reader.close()
    }
}

fun readNumber1(reader:BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }

    println(number)
}

fun readNumber2(reader: BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine())
    }catch (e:NumberFormatException) {
        null
    }

    println(number)
}