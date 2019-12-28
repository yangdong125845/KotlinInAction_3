package com.yangd.kotlininaction_3._6_class_system._1

fun main(args: Array<String>) {
    yellAt(PersonJava(null))
    yellAtSafe(PersonJava(null))

}

fun yellAt(personJava: PersonJava) {
    println(personJava.name.toUpperCase() + "!!!")
}

fun yellAtSafe(personJava: PersonJava) {
    println((personJava.name ?: "Anyone").toUpperCase() + "!!!")
}