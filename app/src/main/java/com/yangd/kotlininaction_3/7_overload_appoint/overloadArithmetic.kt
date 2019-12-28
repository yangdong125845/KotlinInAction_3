package com.yangd.kotlininaction_3.`7_overload_appoint`

import java.math.BigDecimal

fun main(args: Array<String>) {

    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)


    var p3 = Point(10, 20)
    p3 += Point(10, 20)
    println("p3+= Point(10,20): $p3")

    val p = Point(10, 20)
    println(p * 1.5)

    println('a' * 3)

    println(0x0F and 0xF0)
    println(0x0F or 0xF0)
    println(0x1 shl 4)

    val numbers = ArrayList<Int>()
    numbers += 42
    println(numbers[0])

    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list)
    println(newList)

    val p5 = Point(10,20)
    println(-p5)

    var bigDecimal = BigDecimal.ZERO
    println(bigDecimal++)
    println(++bigDecimal)
}

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

}

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}


operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator  fun BigDecimal.inc() = this + BigDecimal.ONE