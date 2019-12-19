package com.yangd.kotlininaction_3.overload_appoint_7

fun main(args: Array<String>) {
    println(Point1(10, 20) == Point1(10, 20))
    println(Point1(10, 20) != Point1(5, 5))
    println(null == Point1(1, 2))

    val p1 = Person_Compare("Alice", "Smith")
    val p2 = Person_Compare("Bob", "Johnson")
    println(p1 < p2)

    println("abc" < "bac")

}

class Point1(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Point1) return false
        return other.x == x && other.y == y
    }
}

class Person_Compare(val firstName: String, val lastName: String) : Comparable<Person_Compare> {
    override fun compareTo(other: Person_Compare): Int {
        return compareValuesBy(this, other, Person_Compare::lastName, Person_Compare::firstName)
    }
}