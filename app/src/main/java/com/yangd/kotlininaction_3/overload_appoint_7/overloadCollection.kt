package com.yangd.kotlininaction_3.overload_appoint_7

import android.os.Build
import android.support.annotation.RequiresApi
import java.lang.IndexOutOfBoundsException
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun main(args: Array<String>) {
    val p = Point(10, 20)
    println(p[1])

    val mutablePoint = MutablePoint(10, 20)
    mutablePoint[1] = 42
    println(mutablePoint)

    val rect = Rectangle(Point(10, 20), Point(50, 50))
    println(Point(20, 30) in rect)

    println(Point(5, 5) in rect)

    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation)
    val n = 9
    println(0..(n + 1))
    (0..n).forEach { println(it) }

    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.y until lowerRight.y
}

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start
        override fun hasNext(): Boolean = current <= endInclusive

        @RequiresApi(Build.VERSION_CODES.O)
        override fun next() = current.apply {
            current = plusDays(1)
        }
    }