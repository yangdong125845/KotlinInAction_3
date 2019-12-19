package com.yangd.kotlininaction_3.lambda_5

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })

    val people = listOf(PersonCollection("Alice", 29), PersonCollection("Bob", 31))
    println(people.filter { it.age > 30 })

    println(list.map { it * it })
    println(people.map { it.name })
    println(people.map(PersonCollection::name))
    println(people.filter { it.age > 30 }.map(PersonCollection::name))
    people.filter { it.age == people.maxBy(PersonCollection::age)?.age }

    val maxAge = people.maxBy(PersonCollection::age)?.age
    people.filter { it.age == maxAge }

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })

    val canBeInClub27 = { p: PersonCollection -> p.age <= 27 }

    val people1 = listOf(PersonCollection("Alice", 27), PersonCollection("Bob", 31))
    println(people1.all(canBeInClub27))

    println(people1.any(canBeInClub27))

    val list2 = listOf(1, 2, 3)
    println(!list2.all { it == 3 })
    println(list.any { it != 3 })

    println(people1.count(canBeInClub27))

    println(people1.filter(canBeInClub27).size)  // 在这种情况下，一个中间集合会被创建并用来存储所有满足判断式的元素
    println(people1.find(canBeInClub27))

    val people2 = listOf(
        PersonCollection("Alice", 31), PersonCollection("Bob", 29),
        PersonCollection("Carol", 31)
    )
    println(people2.groupBy { it.age })

    val list3 = listOf("a", "ab", "b")
    println(list3.groupBy(String::first))

    val strings = listOf("abc","def")
    println(strings.flatMap { it.toList() })

    val books = listOf(Book("Thursday Next", listOf("Jasper Ff orde")),
                                    Book("Mort", listOf("Terry Pratchett")),
                                     Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")))

    println(books.flatMap { it.authors}.toSet())
    val books1 = listOf(listOf("Jasper Ff orde"),
        listOf("Terry Pratchett"),
        listOf("Terry Pratchett", "Neil Gaiman"))
    println(books1.flatten().toSet())


}

data class PersonCollection(val name: String, val age: Int)

class Book(val title: String, val authors: List<String>)

