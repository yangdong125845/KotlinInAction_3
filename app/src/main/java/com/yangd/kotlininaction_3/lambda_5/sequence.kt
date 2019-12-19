package com.yangd.kotlininaction_3.lambda_5

fun main(args: Array<String>) {
    val people = listOf(PersonCollection("Alice", 29), PersonCollection("Bob", 31))

    people.map(PersonCollection::name).filter { it.startsWith("A") }

    people.asSequence().map(PersonCollection::name).filter { it.startsWith("A") }.toList()

    listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }

    listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()

    println(listOf(1, 2, 3, 4).asSequence().map { it * it }.find { it > 3 })

    val people1 = listOf(
        PersonCollection("Alice", 29), PersonCollection("Bob", 31),
        PersonCollection("Charles", 31), PersonCollection("Dan", 21)
    )
    println(people1.asSequence().map(PersonCollection::name).filter { it.length < 4 }.toList())
    println(people1.asSequence().filter { it.name.length < 4 }.map(PersonCollection::name).toList())

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())


}