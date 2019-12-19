package com.yangd.kotlininaction_3.type_system_6._1

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