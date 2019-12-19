package com.yangd.kotlininaction_3.overload_appoint_7

fun main(args: Array<String>) {
    val p = Point(10, 20)
    val (x, y) = p
    println(x)
    println(y)

    val (name, ext) = splitFilename("example.kt")
    println(name)
    println(ext)

    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}

class Point_Component(val x: Int, val y: Int) {

    operator fun component1() = x
    operator fun component2() = y
}

data class NameComponents(val name: String, val extension: String)

fun splitFilename(fullName: String): NameComponents {
    val result = fullName.split(".", limit = 2)
    return NameComponents(result[0], result[1])
}

fun splitFilename1(fullName: String): NameComponents {
    val (name, extension) = fullName.split(".", limit = 2)
    return NameComponents(name, extension)
}

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}