package com.yangd.kotlininaction_3.`8_supper_func_lambda`

import java.lang.StringBuilder

fun main(args: Array<String>) {

    val people = listOf(Person_Control("Alice", 29), Person_Control("Bob", 31))

    lookForALice(people)
    lockForAlice(people)
    lookForAlice_(people)
    lookForAlice_1(people)

    println(StringBuilder().apply sb@{
        listOf(1, 2, 3).apply {
            this@sb.append(this.toString())
        }
    })

    lookForAlice_2(people)

    people.filter(fun(person): Boolean {
        return person.age < 30
    })

    people.filter(fun(person) = person.age < 30)

}

data class Person_Control(val name: String, val age: Int)

fun lookForALice(people: List<Person_Control>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

fun lockForAlice(people: List<Person_Control>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

fun lookForAlice_(people: List<Person_Control>) {
    people.forEach lavel@{
        if (it.name == "Alice") return@lavel
    }
    println("lavel@: Alice might be somewhere")
}

fun lookForAlice_1(people: List<Person_Control>) {
    people.forEach {
        if (it.name == "Alice") return@forEach
    }
    println("@forEach :Alice might be somewhere")
}

fun lookForAlice_2(people: List<Person_Control>) {
    people.forEach(fun(person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })
}
